package com.kb.bchess.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.kb.bchess.R;
import com.kb.bchess.engine.board.BoardView;

public class GameActivity extends AppCompatActivity {

    private View view;
    private BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        view = findViewById(R.id.table);
        boardView = findViewById(R.id.boardView);
    }

    public void setViewVisible(){
        view.setVisibility(View.VISIBLE);
    }

    public void queenOnClick(View view) {

    }

    public void rookOnClick(View view) {

    }

    public void knightOnClick(View view) {

    }

    public void bishopOnClick(View view) {

    }



}
