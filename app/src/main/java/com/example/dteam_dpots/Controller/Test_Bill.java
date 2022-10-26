package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;
import com.example.dteam_dpots.*;
import com.example.dteam_dpots.Model.*;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test_Bill extends AppCompatActivity {
    Button btnAdd;
    Button btnDelete;
    Button btnUpdate;
    Button btnView;

    EditText Date;
    EditText Currency;
    EditText Description;

    ModalBill _model = new ModalBill();
    Spinner spIncomeRange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bill);

        //map ui
        getValue();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                String currency = Currency.getText().toString();
                String description = Description.getText().toString();

                Date date = null;
                try {
                    date = formatter.parse(Date.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //add bill
                 _model.addBill(Double.parseDouble(currency), description, date);

            }});
    }

    /*Map UI*/
    void getValue(){
        btnAdd = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnView = findViewById(R.id.btnView);
        Date = findViewById(R.id.Date);
        Currency = findViewById(R.id.Currency);
        Description = findViewById(R.id.Description);
    }
}