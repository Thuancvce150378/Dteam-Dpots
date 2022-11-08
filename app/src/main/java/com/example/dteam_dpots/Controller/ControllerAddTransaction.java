package com.example.dteam_dpots.Controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dteam_dpots.*;
import com.example.dteam_dpots.ItemView.CustomSpinnerAdapterAdd;
import com.example.dteam_dpots.ItemView.CustomSpinnerItemAdd;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.Model.ModelAddTransaction;


public class ControllerAddTransaction extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageButton ibOK, ibBack;
    EditText txtAmount, editTextDate, txtDescription;
    Spinner customSpinnerAdd;
    ArrayList<CustomSpinnerItemAdd> customList;
    String itemSelectd;
    private ModelAddTransaction _model = new ModelAddTransaction();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        ibOK = findViewById(R.id.ibOKAddTransaction);
        ibOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAll()) {
                    boolean result = _model.addBill(itemSelectd, txtAmount.getText().toString(), editTextDate.getText().toString(), txtDescription.getText().toString());
                    if (result) finish();
                    else Toast.makeText(ControllerAddTransaction.this, "Add failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibBack = findViewById(R.id.ibBackAddTransaction);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ControllerAddTransaction.this, ControllerHome.class);
                startActivity(intent);
            }
        });
        txtAmount = findViewById(R.id.txtAmount);
        txtAmount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    txtAmountValidate(txtAmount);
                }
            }
        });

        editTextDate = findViewById(R.id.editTextDate);
        editTextDate.setHint(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        editTextDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (editTextDate.getText().toString().isEmpty()) {
                        editTextDate.setText(editTextDate.getHint());
                    }
                    editTextDateValidate(editTextDate);
                }
            }
        });
        txtDescription = findViewById(R.id.txtDescription);

        customSpinnerAdd = findViewById(R.id.customIconSpinnerAdd);
        customList = getCustomList();
        CustomSpinnerAdapterAdd adapter = new CustomSpinnerAdapterAdd(this, customList);

        if (customSpinnerAdd != null) {
            customSpinnerAdd.setAdapter(adapter);
            customSpinnerAdd.setOnItemSelectedListener(this);
        }
    }

    private boolean checkAll() {
        return txtAmountValidate(txtAmount) && editTextDateValidate(editTextDate);
    }

    private boolean editTextDateValidate(EditText editTextDate) {
        if(editTextDate.getText().toString().isEmpty()){
            editTextDate.setText(editTextDate.getHint());
        }
        //date check format dd/MM/yyyy
        String[] date = editTextDate.getText().toString().split("/");
        if (date.length != 3) {
            editTextDate.setError("Date format is dd/MM/yyyy");
            return false;
        }
        if (date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) {
            editTextDate.setError("Date format is dd/MM/yyyy");
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
            editTextDate.setError("Date is invalid");
            return false;
        }

        return true;
    }

    private boolean txtAmountValidate(EditText text) {
        if (text.getText().toString().isEmpty()) {
            text.setError("Amount is required");
            return false;
        }

        if (Double.parseDouble(text.getText().toString()) < 1) {
            text.setError("Amount must be greater than 0");
            return false;
        }


        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private ArrayList<CustomSpinnerItemAdd> getCustomList() {
        customList = new ArrayList<>();
        List<PotItem> items = _model.GetPotItems();
        items.forEach(item -> {
            customList.add(new CustomSpinnerItemAdd(item.getName(), item.getPicture(), item.getPot().getShortName(), item.getID()));
        });
        return customList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomSpinnerItemAdd item = (CustomSpinnerItemAdd) adapterView.getSelectedItem();
//        this._model.getPotItem(item.getId_ItemPot());
        itemSelectd= item.getId_ItemPot();
//        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}