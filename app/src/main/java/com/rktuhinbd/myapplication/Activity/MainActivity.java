package com.rktuhinbd.myapplication.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rktuhinbd.myapplication.Model.OtpModel;
import com.rktuhinbd.myapplication.Network.RetrofitClient;
import com.rktuhinbd.myapplication.R;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static int number;
    private String apiKey = "C20039925d0896b4f3f569.93047578";
    private String messageType = "text";
    private String contactNumber = "88";
    private String senderId = "8804445629107";
    private static String otpCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etPhone = findViewById(R.id.et_contact);
        Button btnVerify = findViewById(R.id.btn_otp);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomNumberString();
                contactNumber += etPhone.getText().toString();

                sendOtp();

                Intent i = new Intent(getApplication(), OtpActivity.class);
                i.putExtra("otp", otpCode);
                startActivity(i);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    public static void getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        String.format("%06d", number);
        otpCode = String.valueOf(number);
    }

    private void sendOtp(){
        Log.e("Data", apiKey + " " + messageType + " " + contactNumber + " " + senderId + " " + otpCode);

        Call<OtpModel> call = RetrofitClient.getInstance().getApi().createOtpPost(apiKey, messageType, contactNumber, senderId, otpCode);
        call.enqueue(new Callback<OtpModel>() {
            @Override
            public void onResponse(Call<OtpModel> call, Response<OtpModel> response) {
                    OtpModel otp = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<OtpModel> call, Throwable t) {
                Log.e("Exception: ", t.getMessage());
            }
        });
    }
}