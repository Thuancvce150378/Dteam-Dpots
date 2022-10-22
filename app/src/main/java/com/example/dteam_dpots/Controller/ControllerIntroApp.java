package com.example.dteam_dpots.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dteam_dpots.Model.ModelIntroApp;
import com.example.dteam_dpots.*;

public class ControllerIntroApp extends AppCompatActivity {
    ImageButton btnNext;
    private final ModelIntroApp _model = new ModelIntroApp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_app);

        GetITemView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ControllerIntroApp.this, ControllerPotsSetup.class));
            }
        });

    }
    public void GetITemView(){
        btnNext = findViewById(R.id.btnNext)    ;
    }
}