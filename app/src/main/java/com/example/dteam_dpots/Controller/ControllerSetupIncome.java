package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Model.*;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class ControllerSetupIncome extends AppCompatActivity {
    ModelSetupIncome _model = new ModelSetupIncome();
    ImageButton btnNext;
    EditText txtAmount;
    Spinner spIncomeRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_income);
        try {
            if (_model.checkIncome()) {
                Intent intent = new Intent(ControllerSetupIncome.this, ControllerIntroApp.class);
                startActivity(intent);
            }
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        getValue();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                _model.AddIncome(spIncomeRange.getSelectedItem().toString(), Double.parseDouble(txtAmount.getText().toString()));
                startActivity(new Intent(ControllerSetupIncome.this, ControllerIntroApp.class));
            }
        });
    }

    void getValue() {
        Log.d("IncomeSetup", "IncomeSetup");
        btnNext = findViewById(R.id.btnNext);
        spIncomeRange = findViewById(R.id.spIncomeRange);
        txtAmount = (EditText) findViewById(R.id.txtAmount);
    }
}