package com.kb.bchess.engine.pieces;

import android.graphics.BitmapFactory;

import com.kb.bchess.R;
import com.kb.bchess.activities.MainActivity;
import com.kb.bchess.engine.Data;
import com.kb.bchess.engine.board.Tile;

import java.util.ArrayList;

public class Queen extends Piece {

    private ArrayList<Direction> directions;

    public Queen(Color color) {

        super(color);
        directions = new ArrayList<Direction>();
        directions.add(new Direction(-1,0));
        directions.add(new Direction(1,0));
        directions.add(new Direction(0,-1));
        directions.add(new Direction(0,1));
        directions.add(new Direction(-1,-1));
        directions.add(new Direction(1,-1));
        directions.add(new Direction(-1,1));
        directions.add(new Direction(1,1));
    }

    @Override
    public ArrayList<Tile> possibleMoves(Piece[][] pieces, Tile tile) {
        ArrayList<Tile> result = new ArrayList<>();

        for(Direction direction: directions) {
            int x = tile.getColumn();
            int y = tile.getRow();
            while(Data.areCoordinatesValid(x + direction.x, y + direction.y)) {

                x+=direction.x;
                y+=direction.y;

                if(pieces[x][y] == null) {
                    result.add(new Tile(x, y));
                } else if(pieces[x][y].getColor() != this.color) {
                    result.add(new Tile(x, y));
                    break;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    @Override
    protected void setImage() {
        if(color.equals(Color.WHITE)){
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.white_queen);
        } else {
            image = BitmapFactory.decodeResource(MainActivity.getAppContext().getResources(), R.drawable.black_queen);
        }
    }
}
