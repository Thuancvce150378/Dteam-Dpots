package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Model.ModelIntroApp;

public class ControllerIntroApp extends AppCompatActivity {
    TextView txtText;

    private final ModelIntroApp _model= new ModelIntroApp();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_app);

        txtText = findViewById(R.id.textView2);
        txtText.setText("ulatrashort");
//        txtText.setText(_model.getListIncome());
    }
}