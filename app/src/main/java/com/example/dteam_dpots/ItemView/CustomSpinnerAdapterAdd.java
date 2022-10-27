package com.example.dteam_dpots.ItemView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dteam_dpots.*;

import java.util.List;

public class CustomSpinnerAdapterAdd extends ArrayAdapter<CustomSpinnerItemAdd> {

    public CustomSpinnerAdapterAdd(@NonNull Context context, @NonNull List<CustomSpinnerItemAdd> customList) {
        super(context, 0, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_spinner_layout_add,parent, false);
        }
        CustomSpinnerItemAdd customSpinnerItemAdd = getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.ivSpinnerLayoutAdd);
        TextView spinnerTV = convertView.findViewById(R.id.tvSpinnerLayoutAdd);
        TextView spinnerDesc = convertView.findViewById(R.id.tvSpinnerDesc);
        if (customSpinnerItemAdd != null) {
            spinnerIV.setImageResource(customSpinnerItemAdd.getSpinnerItemImage());
            spinnerTV.setText(customSpinnerItemAdd.getSpinnerItemName());
            spinnerDesc.setText(customSpinnerItemAdd.getSpinnerItemDesc());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_dropdown_add,parent, false);
        }
        CustomSpinnerItemAdd customSpinnerItemAdd = getItem(position);
        ImageView dropDownIV = convertView.findViewById(R.id.ivCustomDropdownAdd);
        TextView dropDownTV = convertView.findViewById(R.id.tvCustomDropdownAdd);
        TextView dropDownDesc = convertView.findViewById(R.id.tvCustomDropdownDesc);
        if (customSpinnerItemAdd != null) {
            dropDownIV.setImageResource(customSpinnerItemAdd.getSpinnerItemImage());
            dropDownTV.setText(customSpinnerItemAdd.getSpinnerItemName());
            dropDownDesc.setText(customSpinnerItemAdd.getSpinnerItemDesc());
        }
        return convertView;
    }
}
