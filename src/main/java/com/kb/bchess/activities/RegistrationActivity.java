package com.kb.bchess.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.kb.bchess.R;
import com.kb.bchess.communication.RetrofitAdapter;
import com.kb.bchess.data.RegistrationForm;
import com.kb.bchess.communication.ServerCommunicationApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class RegistrationActivity extends AppCompatActivity {

    private RequestQueue queue;
    private ServerCommunicationApi serverCommunicationApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Retrofit retrofit = RetrofitAdapter.getInstance(getApplicationContext());

        serverCommunicationApi = retrofit.create(ServerCommunicationApi.class);
    }

    public void onClickRegister(View view) {
        EditText email = findViewById(R.id.EmailEditText);
        EditText nickname = findViewById(R.id.NicknameEditText);
        EditText password = findViewById(R.id.PasswordEditText);

        RegistrationForm registrationForm = new RegistrationForm(
                email.getText().toString(),
                nickname.getText().toString(),
                password.getText().toString()
        );

        Call<String> call = serverCommunicationApi.register(registrationForm);

        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
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
