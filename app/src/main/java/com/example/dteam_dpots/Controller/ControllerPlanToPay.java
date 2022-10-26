package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.dteam_dpots.*;

public class ControllerPlanToPay extends AppCompatActivity {

    ImageButton ibAddPlan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_to_pay);

        ibAddPlan = findViewById(R.id.ibAddPlan);
        ibAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerPlanToPay.this, ControllerAddPlan.class);
                startActivity(intent);
            }
        });
    }
}