package com.kb.bchess.engine.pieces;

import android.graphics.Bitmap;

import com.kb.bchess.engine.board.Board;
import com.kb.bchess.engine.board.Tile;

import java.util.ArrayList;

public abstract class Piece {

    protected int row;
    protected int column;

    public Color getColor() {
        return color;
    }

    protected final Color color;
    protected Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public Piece(Color color){
        this.color = color;
        this.row = row;
        this.column = column;
        setImage();
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCoordinates(int column, int row){
        this.column = column;
        this.row = row;
    }

    public abstract ArrayList<Tile> possibleMoves(Piece[][] pieces, Tile tile);

    protected abstract void setImage();

    protected class Direction {
        public int x;
        public int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
