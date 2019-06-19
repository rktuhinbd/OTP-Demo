package com.rktuhinbd.myapplication.Model;

import com.rktuhinbd.myapplication.Network.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseUrl {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://esms.mimsms.com/smsapi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiInterface api = retrofit.create(ApiInterface.class);
}
