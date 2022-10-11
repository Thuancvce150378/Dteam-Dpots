package com.example.dteam_dpots;

import androidx.appcompat.app.AppCompatActivity;
import com.example.dteam_dpots.Controller.*;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Intent intent = new Intent(MainActivity.this, ControllerSetupIncome.class);
            startActivity(intent);

    }
}