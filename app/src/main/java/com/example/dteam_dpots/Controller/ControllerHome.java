package com.example.dteam_dpots.Controller;
import com.example.dteam_dpots.Beans.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dteam_dpots.Model.ModelHome;
import com.example.dteam_dpots.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ControllerHome extends AppCompatActivity {
    ModelHome _model = new ModelHome();
    FloatingActionButton fabAddTransaction, fabPlan, fabTotalHistory;
    ImageButton ibUpdateIncome;
    ImageButton ibNECPot, ibLTSPot, ibEDUPot, ibPLAYPot, ibFFAPot, ibGIVEPot;
    TextView txtIncome_int, txtBalance_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fabAddTransaction = findViewById(R.id.btnAddTransaction);
        txtIncome_int = findViewById(R.id.txtIncome_int);
        txtIncome_int.setText(_model.doubleToMoneyVND(_model.income.getAmount()));
        txtBalance_int = findViewById(R.id.txtBalance_int);
        txtBalance_int.setText(_model.doubleToMoneyVND(_model.balance));

        //change activity to add transaction
        fabAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerAddTransaction.class);
                changePage(intent);
            }
        });

        ibUpdateIncome = findViewById(R.id.ibUpdateIncome);

        //change activity to update income
        ibUpdateIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerUpdateIncome.class);
                changePage(intent);
            }
        });

        ibNECPot = findViewById(R.id.ibNECPot);
        ibLTSPot = findViewById(R.id.ibLTSPot);
        ibEDUPot = findViewById(R.id.ibEDUPot);
        ibPLAYPot = findViewById(R.id.ibPLAYPot);
        ibFFAPot = findViewById(R.id.ibFFAPot);
        ibGIVEPot = findViewById(R.id.ibGIVEPot);

        //change activity to pot history
        ibNECPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "NEC");
                changePage(intent);
            }
        });

        ibLTSPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "LTS");
                changePage(intent);
            }
        });

        ibEDUPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "EDU");
                changePage(intent);
            }
        });

        ibPLAYPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "PLAY");
                changePage(intent);
            }
        });

        ibFFAPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "FFA");
                changePage(intent);
            }
        });

        ibGIVEPot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerHistoryPot.class);
                intent.putExtra("potName", "GIVE");
                changePage(intent);
            }
        });

        fabPlan = findViewById(R.id.fabPlan);
        //change activity to Plan page
        fabPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerPlanToPay.class);
                changePage(intent);
            }
        });

        fabTotalHistory = findViewById(R.id.fabTotalHistory);
        //change activity to total history page
        fabTotalHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerHome.this, ControllerTotalHistory.class);
                changePage(intent);
            }
        });
    }
    private void changePage(Intent activity) {
        try {
            if(activity != null) {
                startActivity(activity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}