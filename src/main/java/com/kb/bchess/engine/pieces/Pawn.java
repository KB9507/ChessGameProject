package com.kb.bchess.engine.pieces;

import android.graphics.BitmapFactory;

import com.kb.bchess.R;
import com.kb.bchess.activities.MainActivity;
import com.kb.bchess.engine.Data;
import com.kb.bchess.engine.board.Tile;

import java.util.ArrayList;

public class Pawn extends Piece {

    boolean firstMoveMade = false;
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public ArrayList<Tile> possibleMoves(Piece[][] pieces, Tile tile) {
        ArrayList<Tile> result = new ArrayList<>();

        int x = tile.getColumn();
        int y = tile.getRow();

        if(color == Color.WHITE) {
              result = checkMovesForWhite(pieces, x, y, result);
        } else {
           result = checkMovesForBlack(pieces, x, y, result);
        }

        return result;
    }

    private ArrayList<Tile> checkMovesForWhite(Piece[][] pieces, int x, int y, ArrayList<Tile> moves){

        if(y-1 < 0) return moves;

        if((x-1) > 0 && pieces[x-1][y-1] != null && pieces[x-1][y-1].getColor() == Color.BLACK) {
            moves.add(new Tile(x-1,y-1));
        }
        if(pieces[x][y-1] == null) {
            moves.add(new Tile(x,y-1));
        }
        if((x+1) < Data.BOARD_SIZE && pieces[x+1][y-1] != null && pieces[x+1][y-1].getColor() == Color.BLACK) {
            moves.add(new Tile(x+1,y-1));
        }
        if(!firstMoveMade) {
            if(pieces[x][y-1] == null && pieces[x][y-2] == null) {
                moves.add(new Tile(x,y-2));
            }
        }
        return moves;
    }

    private ArrayList<Tile> checkMovesForBlack(Piece[][] pieces, int x, int y, ArrayList<Tile> moves){

        if(y+1 > Data.BOARD_SIZE) return moves;

        if((x-1) > 0 && pieces[x-1][y+1] != null && pieces[x-1][y+1].getColor() == Color.WHITE) {
            moves.add(new Tile(x-1,y+1));
        }
        if(pieces[x][y+1] == null) {
            moves.add(new Tile(x,y+1));
        }
        if((x+1) < Data.BOARD_SIZE && pieces[x+1][y+1] != null && pieces[x+1][y+1].getColor() == Color.WHITE) {
            moves.add(new Tile(x+1,y+1));
        }
        if(!firstMoveMade) {
            if(pieces[x][y+1] == null && pieces[x][y+2] == null) {
                moves.add(new Tile(x,y+2));
            }
        }
        return moves;
    }


    @Override
    protected void setImage() {
        if(color.equals(Color.WHITE)){
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.white_pawn);
        } else {
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.black_pawn);
        }
    }

    public boolean isFirstMoveMade() {
        return firstMoveMade;
    }

    public void setFirstMoveMade(boolean firstMoveMade) {
        this.firstMoveMade = firstMoveMade;
    }
}
