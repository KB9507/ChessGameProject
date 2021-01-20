package com.kb.bchess.engine.pieces;

import android.graphics.BitmapFactory;

import com.kb.bchess.R;
import com.kb.bchess.activities.MainActivity;
import com.kb.bchess.engine.Data;
import com.kb.bchess.engine.board.Tile;

import java.util.ArrayList;

public class Knight extends Piece {

    private ArrayList<Direction> directions;

    public Knight(Color color) {

        super(color);
        directions = new ArrayList<>();

        directions.add(new Direction(1, -2));
        directions.add(new Direction(2, -1));

        directions.add(new Direction(2, 1));
        directions.add(new Direction(1, 2));

        directions.add(new Direction(-1, 2));
        directions.add(new Direction(-2, 1));

        directions.add(new Direction(-2, -1));
        directions.add(new Direction(-1, -2));
    }

    @Override
    public ArrayList<Tile> possibleMoves(Piece[][] pieces, Tile tile) {
        ArrayList<Tile> result = new ArrayList<>();

        for (Direction direction : directions) {
            int x = tile.getColumn();
            int y = tile.getRow();
            if(Data.areCoordinatesValid(x + direction.x, y + direction.y)){
                x+=direction.x;
                y+=direction.y;

                if(pieces[x][y] == null) {
                    result.add(new Tile(x, y));
                } else if(pieces[x][y].getColor() != this.color) {
                    result.add(new Tile(x, y));
                }
            }

        }
        return result;
    }

    @Override
    protected void setImage() {
        if(color.equals(Color.WHITE)){
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.white_knight);
        } else {
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.black_knight);
        }
    }
}
