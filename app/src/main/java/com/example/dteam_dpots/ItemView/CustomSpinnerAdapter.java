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

import java.util.ArrayList;

import com.example.dteam_dpots.*;


public class CustomSpinnerAdapter extends ArrayAdapter<CustomSpinnerItem> {
    public CustomSpinnerAdapter(@NonNull Context context, ArrayList<CustomSpinnerItem> customList) {
        super(context, 0, customList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_spinner_layout,parent, false);
        }
        CustomSpinnerItem customSpinnerItem = getItem(position);
        ImageView spinnerIV = convertView.findViewById(R.id.ivSpinnerLayout);
        TextView spinnerTV = convertView.findViewById(R.id.tvSpinnerLayout);
        if (customSpinnerItem != null) {
            spinnerIV.setImageResource(customSpinnerItem.getSpinnerItemImage());
            spinnerTV.setText(customSpinnerItem.getSpinnerItemName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_custom_dropdown,parent, false);
        }
        CustomSpinnerItem customSpinnerItem = getItem(position);
        ImageView dropDownIV = convertView.findViewById(R.id.ivCustomDropdown);
        TextView dropDownTV = convertView.findViewById(R.id.tvCustomDropdown);
        if (customSpinnerItem != null) {
            dropDownIV.setImageResource(customSpinnerItem.getSpinnerItemImage());
            dropDownTV.setText(customSpinnerItem.getSpinnerItemName());
        }
        return convertView;
    }
}
