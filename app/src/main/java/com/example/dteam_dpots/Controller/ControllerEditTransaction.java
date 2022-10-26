package com.example.dteam_dpots.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.ItemView.CustomSpinnerAdapter;
import com.example.dteam_dpots.ItemView.CustomSpinnerItem;

import java.util.ArrayList;

public class ControllerEditTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner customSpinner;
    ArrayList<CustomSpinnerItem> customList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaction);

        customSpinner = findViewById(R.id.customIconSpinner);
        customList = getCustomList();
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, customList);
        if (customSpinner != null) {
            customSpinner.setAdapter(adapter);
            customSpinner.setOnItemSelectedListener(this);
        }
    }

    private ArrayList<CustomSpinnerItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomSpinnerItem("Food", R.drawable.kfc_chicken));
        customList.add(new CustomSpinnerItem("Transportation", R.drawable.ic_transpotation));
        customList.add(new CustomSpinnerItem("Personal", R.drawable.ic_personal));
        customList.add(new CustomSpinnerItem("Home Tools", R.drawable.ic_home_tools));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomSpinnerItem item = (CustomSpinnerItem) adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}