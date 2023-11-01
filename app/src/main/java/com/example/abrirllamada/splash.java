package com.example.abrirllamada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class splash extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { }
            @Override
            public void onFinish() {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        };
        countDownTimer.start();
    }
}