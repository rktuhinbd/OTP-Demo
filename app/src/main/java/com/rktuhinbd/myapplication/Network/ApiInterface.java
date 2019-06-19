package com.rktuhinbd.myapplication.Network;

import com.rktuhinbd.myapplication.Model.OtpModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("http://esms.mimsms.com/smsapi")
    Call<OtpModel> createOtpPost(
            @Field("api_key") String apiKey,
            @Field("type") String messageType,
            @Field("contacts") String contactNumber,
            @Field("senderid") String senderId,
            @Field("msg") String otpCode
    );
}