package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.dteam_dpots.*;
import android.view.View;
public class ControllerAddPlan extends AppCompatActivity {

    ImageButton ibOK, ibBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        ibOK = findViewById(R.id.ibOKAddPlan);
        ibBack = findViewById(R.id.ibBackAddPlan);

        ibOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerAddPlan.this, ControllerPlanToPay.class);
                startActivity(intent);
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerAddPlan.this, ControllerPlanToPay.class);
                startActivity(intent);
            }
        });
    }
}