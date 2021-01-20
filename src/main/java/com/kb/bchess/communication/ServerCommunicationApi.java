package com.kb.bchess.communication;

import com.kb.bchess.data.RegistrationForm;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServerCommunicationApi {

    @FormUrlEncoded
    @POST("login")
    Call<String> login(@FieldMap Map<String, String> fields);

    @POST("register")
    Call<String> register(@Body RegistrationForm registrationForm);

}
