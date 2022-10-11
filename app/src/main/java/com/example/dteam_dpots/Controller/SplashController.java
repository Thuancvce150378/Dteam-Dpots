package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Model.SplashModel;


public class SplashController extends AppCompatActivity {
    public SplashModel _model = new SplashModel();
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        txt = findViewById(R.id.textView);
        txt.setText(_model.getText());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashController.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}