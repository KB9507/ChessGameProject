package com.kb.bchess.engine.board;

import com.kb.bchess.engine.pieces.Piece;

public class Tile {

    private int row;
    private int column;
    private Piece pieceOnTile;

    public boolean isOccuppied(){
        if(pieceOnTile != null) return true;
        return false;
    }

    public Piece getPieceOnTile() {
        return pieceOnTile;
    }

    public void setPieceOnTile(Piece pieceOnTile) {
        this.pieceOnTile = pieceOnTile;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Tile(int column, int row) {
        this.row = row;
        this.column = column;
        pieceOnTile = null;
    }

    @Override
    public int hashCode(){
        return row*17+column*19;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Tile other = (Tile) o;
        if(row == other.getRow() && column == other.getColumn())
            return true;
        return false;
    }
}
