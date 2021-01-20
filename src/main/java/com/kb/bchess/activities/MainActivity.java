package com.kb.bchess.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.kb.bchess.R;
import com.kb.bchess.communication.SessionManager;


public class MainActivity<onCreateOptions> extends AppCompatActivity {

    private RequestQueue queue;
    private SessionManager sessionManager;
    private final int ITEM_1 = 1;
    private static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        sessionManager = new SessionManager(getApplicationContext());
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add(Menu.NONE, ITEM_1, Menu.NONE, "User Account");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        if(sessionManager.isLogged()) {
            item.setIcon(R.drawable.ic_account_circle_black_24dp);
        } else {
            item.setIcon(R.drawable.ic_assignment_ind_black_24dp);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case ITEM_1:
                if(sessionManager.isLogged()){
                    Intent intent = new Intent(this, UserAccount.class);
                    this.startActivity(intent);
                } else {
                    Intent intent = new Intent(this, LoginActivity.class);
                    this.startActivity(intent);
                }
                break;
        }

        return true;
    }

    public void playOnClick(View view) {

        Intent intent = new Intent(this, GameActivity.class);
        this.startActivity(intent);
    }
}
