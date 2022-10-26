package com.example.dteam_dpots;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import com.example.dteam_dpots.Controller.*;
import android.content.Intent;
import android.os.Bundle;
import com.example.dteam_dpots.Model.*;
import com.example.dteam_dpots.Base.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //check if have been setup to skip setup
        try {
            if (isSetup()) {
                //set up ControllerHome as default Intert
                Intent intent = new Intent(MainActivity.this, ControllerHome.class);
                startActivity(intent);
                return;
            }
            //set up ControllerSetup as default Intert
            Intent intent = new Intent(MainActivity.this, ControllerSetupIncome.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isSetup() {
        Model m = new Model();
        return m.isSetup();
    }
}