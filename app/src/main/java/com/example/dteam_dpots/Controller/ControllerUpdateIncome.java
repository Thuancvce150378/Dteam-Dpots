package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.dteam_dpots.*;

public class ControllerUpdateIncome extends AppCompatActivity {

    ImageButton ibOK, ibBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);

        ibOK = findViewById(R.id.ibOKUpdateIncome);
        ibBack = findViewById(R.id.ibBackUpdateIncome);

        ibOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerUpdateIncome.this, ControllerHome.class);
                startActivity(intent);
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerUpdateIncome.this, ControllerHome.class);
                startActivity(intent);
            }
        });
    }
}