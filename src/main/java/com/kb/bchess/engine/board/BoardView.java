package com.kb.bchess.engine.board;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.kb.bchess.engine.Data;
import com.kb.bchess.engine.pieces.Piece;

import java.util.ArrayList;

public class BoardView extends View {

    private static int CLICK_THRESHOLD = 300;

    private final float frame_size;
    private final float tile_size;

    public Board getBoard() {
        return board;
    }

    private Board board;
    private Tile selectedTile;
    private boolean pieceSelected = false;

    public BoardView(Context context, AttributeSet attr) {
        super(context, attr);
        frame_size = getDisplayWidth();
        tile_size = frame_size / Data.BOARD_SIZE;
        board = new Board(Data.standardPiecesPosition());
    }

    private int getDisplayWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBoard(canvas);
        drawPieces(canvas, board.getPieces());
        drawMoves(canvas, board.availableMovesFor(selectedTile));
    }

    private void drawMoves(Canvas canvas, ArrayList<Tile> moves) {

        if(moves == null) return;

        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setAlpha(100);
        for(Tile tile: moves){
            Rect rectangle = new Rect(
                    Math.round(tile.getColumn() * tile_size),
                    Math.round(tile.getRow() * tile_size),
                    Math.round(tile.getColumn() * tile_size + tile_size),
                    Math.round(tile.getRow() * tile_size + tile_size));
            canvas.drawRect(rectangle, paint);
        }
    }

    private void drawPieces(Canvas canvas, Piece[][] positions) {

        for(int i=0; i<positions.length; i++){
            for(int j=0; j<positions[i].length; j++) {
                if(positions[i][j] != null) {
                    Rect rectangle = new Rect(
                            Math.round(i * tile_size),
                            Math.round(j * tile_size),
                            Math.round(i * tile_size + tile_size),
                            Math.round(j * tile_size + tile_size));

                    canvas.drawBitmap(positions[i][j].getImage(), null, rectangle, null);
                }
            }
        }
    }

    public void drawBoard(Canvas canvas){
        Paint paint = new Paint();
        for(int x = 0; x < Data.BOARD_SIZE; x++) {
            for (int y = 0; y < Data.BOARD_SIZE; y++) {
                if ((x + y) % 2 == 0) {
                    paint.setColor(Color.LTGRAY);
                } else {
                    paint.setColor(Color.DKGRAY);
                }
                canvas.drawRect(x * tile_size, y * tile_size, (x + 1) * tile_size, (y + 1) * tile_size, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        long duration = event.getEventTime() - event.getDownTime();

        if (event.getAction() == MotionEvent.ACTION_UP && duration < CLICK_THRESHOLD) {

            float x_absolute = event.getX();
            float y_absolute = event.getY();

            int x = (int) Math.floor((float)x_absolute/tile_size);
            int y = (int) Math.floor((float)y_absolute/tile_size);

            Tile tile = new Tile(x, y);
            if(!pieceSelected){
                if(board.getPieces()[x][y] != null) {
                    selectedTile = tile;
                    pieceSelected = true;
                    invalidate();
                }
            } else {
                if(board.movePiece(selectedTile, tile)) {
                    pieceSelected = false;
                    invalidate();
                } else if(board.getPieces()[x][y] != null) {
                    selectedTile = tile;
                    pieceSelected = true;
                    invalidate();
                }
            }
        }

        return true;
    }
}