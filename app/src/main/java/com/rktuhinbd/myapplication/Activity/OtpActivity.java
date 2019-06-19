package com.rktuhinbd.myapplication.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;
import com.rktuhinbd.myapplication.R;

public class OtpActivity extends AppCompatActivity {

    private String otpCode, receivedOtpCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        receivedOtpCode = getIntent().getStringExtra("otp");

        Pinview pinview = findViewById(R.id.pinview);

        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                otpCode = pinview.getValue();
                if (receivedOtpCode.equals(otpCode)){
                    Toast.makeText(getApplicationContext(), "Code Matched! :-)", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Code didn't match! :'(", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
