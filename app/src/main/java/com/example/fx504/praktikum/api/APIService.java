package com.example.fx504.praktikum.api;

import com.example.fx504.praktikum.model.ResponseApi;
import com.example.fx504.praktikum.model.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseApi>CreateMember(@Field("user_name") String user_name,
                                  @Field("user_pass") String user_pass,
                                  @Field("user_email") String user_email,
                                  @Field("user_tlfn") String user_tlfn
                               );

    @FormUrlEncoded
    @POST("login")
    Call<ResponseLogin>LoginUser(@Field("user_email") String user_email,
                                 @Field("user_pass") String user_pass);

}
