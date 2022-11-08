package com.example.dteam_dpots.Controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dteam_dpots.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import  com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.ItemView.CustomSpinnerItemAdd;
import com.example.dteam_dpots.Model.ModelEditTransaction;
import com.example.dteam_dpots.ItemView.*;
import com.google.android.material.textfield.TextInputEditText;

public class ControllerEditTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ModelEditTransaction _model = new ModelEditTransaction();
    Spinner customSpinner;
    ArrayList<CustomSpinnerItemAdd> customList;
    TextInputEditText txtEditCurrencyInput, txtEditDateInput, txtDescriptionInput;
    ImageButton ibOK, ibBack;
    private Bill Bill;
    String itemSelected ;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_transaction);
        String pillID = getIntent().getStringExtra("PillID");
        try {
            Bill = _model.getBill(pillID);
        }catch (Exception e){
            Log.e("Error", e.getMessage());
        }


        customSpinner = findViewById(R.id.customIconSpinner);
        customList = getCustomList(Bill.getID_Pottem());
        CustomSpinnerAdapterAdd adapter = new CustomSpinnerAdapterAdd(this, customList);
        if (customSpinner != null) {
            customSpinner.setAdapter(adapter);
            customSpinner.setOnItemSelectedListener(this);
        }
        txtEditCurrencyInput = findViewById(R.id.txtEditCurrencyInput);
        txtEditCurrencyInput.setText(_model.formatCurrency(Bill.getCurrency()));
        txtEditCurrencyInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    txtEditCurrencyInputValidate(txtEditCurrencyInput);
                }
            }
        });

        txtEditDateInput = findViewById(R.id.txtEditDateInput);
        txtEditDateInput.setText(_model.dateDdMmYyyy(Bill.getDate()));
        txtEditDateInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    txtEditDateInputValidate(txtEditDateInput);
                }
            }
        });

        txtDescriptionInput = findViewById(R.id.txtDescriptionInput);
        txtDescriptionInput.setText(Bill.getDescription());

        ibBack = findViewById(R.id.ibBackEditTransaction);

        ibOK = findViewById(R.id.ibOKEditTransaction);
        ibOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update there
                    if(ValidateAll()){
                    boolean result = _model.updateBill(itemSelected,txtEditCurrencyInput.getText().toString(), txtEditDateInput.getText().toString(), txtDescriptionInput.getText().toString());
                    if(result) finish();
                }
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean ValidateAll() {
        return txtEditCurrencyInputValidate(txtEditCurrencyInput) && txtEditDateInputValidate(txtEditDateInput);
    }

    private boolean txtEditDateInputValidate(TextInputEditText txtEditDateInput) {
        //date check format dd/MM/yyyy
        String[] date = txtEditDateInput.getText().toString().split("/");
        if (date.length != 3) {
            txtEditDateInput.setError("Date format is dd/MM/yyyy");
            return false;
        }
        if (date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) {
            txtEditDateInput.setError("Date format is dd/MM/yyyy");
            return false;
            //if null get default value

        }
        //date check valid
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        try {
            calendar.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]) - 1, Integer.parseInt(date[0]));
            calendar.getTime();
        } catch (Exception e) {
            txtEditDateInput.setError("Date is invalid");
            return false;
        }

        return true;
    }

    private boolean txtEditCurrencyInputValidate(TextInputEditText txtEditCurrencyInput) {
        if (txtEditCurrencyInput.getText().toString().isEmpty()) {
            txtEditCurrencyInput.setError("Amount is required");
            return false;
        }

        if (Double.parseDouble(txtEditCurrencyInput.getText().toString()) < 1) {
            txtEditCurrencyInput.setError("Amount must be greater than 0");
            return false;
        }


        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<CustomSpinnerItemAdd> getCustomList(String idPotItem) {
        customList = new ArrayList<>();
        List<PotItem> items = _model.GetPotItems();
        PotItem firstItem;
        for (PotItem item : items) {
            if (item.getID().equals(idPotItem)) {
                firstItem = item;
                items.remove(item);
                items.add(0, firstItem);
                break;
            }
        }

        items.forEach(item -> {
            customList.add(new CustomSpinnerItemAdd(item.getName(), item.getPicture(), item.getPot().getShortName(), item.getID()));
        });
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomSpinnerItemAdd item = (CustomSpinnerItemAdd) adapterView.getSelectedItem();
        itemSelected= item.getId_ItemPot();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}