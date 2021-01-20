package com.kb.bchess.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.kb.bchess.data.LoginForm;
import com.kb.bchess.R;
import com.kb.bchess.communication.RetrofitAdapter;
import com.kb.bchess.communication.ServerCommunicationApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    ServerCommunicationApi serverCommunicationApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Retrofit retrofit = RetrofitAdapter.getInstance(getApplicationContext());

        serverCommunicationApi = retrofit.create(ServerCommunicationApi.class);

        textView = findViewById(R.id.RegisterText);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });
    }


    public void onClickLogin(View view) {

        EditText loginEditText = findViewById(R.id.EmailEditText);
        String login = loginEditText.getText().toString();

        EditText passwordEditText = findViewById(R.id.PasswordEditText);
        String password = passwordEditText.getText().toString();

        LoginForm loginForm = new LoginForm(login, password);

        Call<String> call = serverCommunicationApi.login(loginForm.toMap());

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(!response.isSuccessful()) {
                    Log.i("onResponse", String.valueOf(response.code()));
                }
                Log.i("onResponse", response.toString());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("onFailure", t.getMessage());
            }
        });

    }
}
