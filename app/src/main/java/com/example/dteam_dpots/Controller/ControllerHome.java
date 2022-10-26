package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.dteam_dpots.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ControllerHome extends AppCompatActivity {

    FloatingActionButton fabAddTransaction, fabPlan, fabTotalHistory;
    ImageButton ibUpdateIncome;
    ImageButton ibNECPot, ibLTSPot, ibEDUPot, ibPLAYPot, ibFFAPot, ibGIVEPot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fabAddTransaction = findViewById(R.id.btnAddTransaction);

        //change activity to add transaction
        fabAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerAddTransaction.class);
                startActivity(intent);
            }
        });

        ibUpdateIncome = findViewById(R.id.ibUpdateIncome);

        //change activity to update income
        ibUpdateIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerUpdateIncome.class);
                startActivity(intent);
            }
        });

        ibNECPot = findViewById(R.id.ibNECPot);
        //change activity to NEC Pot
        ibNECPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                startActivity(intent);
            }
        });

        fabPlan = findViewById(R.id.fabPlan);
        //change activity to Plan page
        fabPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerPlanToPay.class);
                startActivity(intent);
            }
        });

        fabTotalHistory = findViewById(R.id.fabTotalHistory);
        //change activity to total history page
        fabTotalHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerTotalHistory.class);
                startActivity(intent);
            }
        });
    }
}