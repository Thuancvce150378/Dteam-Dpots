package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dteam_dpots.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ControllerHome extends AppCompatActivity {

    FloatingActionButton fabAddTransaction;
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
    }
}