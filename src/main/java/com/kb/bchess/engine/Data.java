package com.kb.bchess.engine;

import com.kb.bchess.engine.pieces.Bishop;
import com.kb.bchess.engine.pieces.Color;
import com.kb.bchess.engine.pieces.King;
import com.kb.bchess.engine.pieces.Knight;
import com.kb.bchess.engine.pieces.Pawn;
import com.kb.bchess.engine.pieces.Piece;
import com.kb.bchess.engine.pieces.Queen;
import com.kb.bchess.engine.pieces.Rook;

public class Data {
    public final static int BOARD_SIZE = 8;

    public static Piece[][] standardPiecesPosition() {
        Piece[][] pieces = new Piece[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++){
            pieces[i][1] = new Pawn(Color.BLACK);
            pieces[i][BOARD_SIZE - 2] = new Pawn(Color.WHITE);
        }

        pieces[0][0] = new Rook(Color.BLACK);
        pieces[1][0] = new Knight(Color.BLACK);
        pieces[2][0] = new Bishop(Color.BLACK);
        pieces[3][0] = new Queen(Color.BLACK);
        pieces[4][0] = new King(Color.BLACK);
        pieces[5][0] = new Bishop(Color.BLACK);
        pieces[6][0] = new Knight(Color.BLACK);
        pieces[7][0] = new Rook(Color.BLACK);

        pieces[0][BOARD_SIZE-1] = new Rook(Color.WHITE);
        pieces[1][BOARD_SIZE-1] = new Knight(Color.WHITE);
        pieces[2][BOARD_SIZE-1] = new Bishop(Color.WHITE);
        pieces[3][BOARD_SIZE-1] = new Queen(Color.WHITE);
        pieces[4][BOARD_SIZE-1] = new King(Color.WHITE);
        pieces[5][BOARD_SIZE-1] = new Bishop(Color.WHITE);
        pieces[6][BOARD_SIZE-1] = new Knight(Color.WHITE);
        pieces[7][BOARD_SIZE-1] = new Rook(Color.WHITE);

        return pieces;
    }

    public static boolean areCoordinatesValid(int x, int y) {
        if(x >= BOARD_SIZE || x < 0 || y >= BOARD_SIZE || y < 0) return false;
        return true;
    }

    public static boolean isPieceOnTile(Piece[][] pieces, int x, int y){

        //TODO X, Y out of scale

        if(pieces[x][y] == null) {
            return false;
        }
        return true;
    }
}
