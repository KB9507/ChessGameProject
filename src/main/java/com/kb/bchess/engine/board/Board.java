package com.kb.bchess.engine.board;

import com.kb.bchess.engine.Data;
import com.kb.bchess.engine.pieces.Color;
import com.kb.bchess.engine.pieces.Pawn;
import com.kb.bchess.engine.pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private Piece[][] pieces;
    private Map<Tile, ArrayList<Tile>> moves;
    private Color turnOf;

    public Board(Piece[][] pieces) {
        this.pieces = pieces;
        moves = new HashMap<Tile, ArrayList<Tile>>();
        turnOf = Color.WHITE;
        computeListOfMoves();

    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void removePieceAt(Tile tile) {
        pieces[tile.getColumn()][tile.getRow()] = null;
    }

    public void addPiece(Piece piece, Tile tile) {
        pieces[tile.getColumn()][tile.getRow()] = piece;
    }

    public boolean movePiece(Tile from, Tile to) {

        ArrayList listOfMoves = moves.get(from);
        if(listOfMoves != null && listOfMoves.contains(to)) {
            if(turnOf.equals(Color.WHITE)) {
                turnOf = Color.BLACK;
            } else {
                turnOf = Color.WHITE;
            }
            Piece piece = pieceAt(from);
            if(piece instanceof Pawn) {
                ((Pawn) piece).setFirstMoveMade(true);
                if(to.getRow() == (Data.BOARD_SIZE-1) || to.getRow() == 0) {

                }
            }
            removePieceAt(from);
            addPiece(piece, to);
            computeListOfMoves();
            return true;
        }
        return false;

    }

    private void computeListOfMoves() {
        moves.clear();
        for(int i=0; i<pieces.length; i++) {
            for(int j=0; j<pieces[i].length; j++) {
                if(pieces[i][j] != null && pieces[i][j].getColor().equals(turnOf))
                    moves.put(new Tile(i, j), pieces[i][j].possibleMoves(pieces, new Tile(i,j)));
            }
        }
    }

    public Piece pieceAt(Tile tile) {
        return pieces[tile.getColumn()][tile.getRow()];
    }

    public ArrayList<Tile> availableMovesFor(Tile tile){
        return moves.get(tile);
    }
}
