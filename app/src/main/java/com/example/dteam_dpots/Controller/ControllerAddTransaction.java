package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.ItemView.CustomSpinnerAdapterAdd;
import com.example.dteam_dpots.ItemView.CustomSpinnerItemAdd;

import java.util.ArrayList;


public class ControllerAddTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ImageButton ibOK, ibBack;
    Spinner customSpinnerAdd;
    ArrayList<CustomSpinnerItemAdd> customList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        ibOK = findViewById(R.id.ibOKAddTransaction);
        ibBack = findViewById(R.id.ibBackAddTransaction);
        ibOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerAddTransaction.this, ControllerHome.class);
                startActivity(intent);
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerAddTransaction.this, ControllerHome.class);
                startActivity(intent);
            }
        });

        customSpinnerAdd = findViewById(R.id.customIconSpinnerAdd);
        customList = getCustomList();
        CustomSpinnerAdapterAdd adapter = new CustomSpinnerAdapterAdd(this, customList);

        if (customSpinnerAdd != null) {
            customSpinnerAdd.setAdapter(adapter);
            customSpinnerAdd.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomSpinnerItemAdd> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomSpinnerItemAdd("Food", R.drawable.kfc_chicken, "NEC"));
        customList.add(new CustomSpinnerItemAdd("Fuel", R.drawable.gas_station, "NEC"));
        customList.add(new CustomSpinnerItemAdd("Shopping", R.drawable.shopping_cart, "PLAY"));
        customList.add(new CustomSpinnerItemAdd("Charity", R.drawable.volunteering, "GIVE"));
        customList.add(new CustomSpinnerItemAdd("Cinema", R.drawable.cinema, "PLAY"));
        customList.add(new CustomSpinnerItemAdd("Learn English", R.drawable.learning, "LTS"));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomSpinnerItemAdd item = (CustomSpinnerItemAdd) adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}