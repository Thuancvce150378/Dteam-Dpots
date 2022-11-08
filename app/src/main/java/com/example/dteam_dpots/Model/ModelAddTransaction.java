package com.example.dteam_dpots.Model;

import android.os.Build;
import android.text.Editable;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.Base.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ModelAddTransaction extends Model {
    public ModelAddTransaction() {
        super();
    }
    List<PotItem> listPotItem;


    public List<PotItem> GetPotItems() {
        this.listPotItem = App.dbcontext.getPotItem();
        return this.listPotItem;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public PotItem getPotItem(String id_itemPot) {
        if(this.listPotItem != null) {
            return this.listPotItem.stream().filter(x -> x.getID().equals(id_itemPot)).findFirst().orElse(null);
        }
        return null;
    }

    public boolean addBill(String idPotItem, String amount,String date, String description) {

        Bill Bill = null;
        try {
            Bill = new Bill(
                    App.uuid.genID(),
                    idPotItem,
                    App.format.getDateDdMmYyyy(date),
                    Double.parseDouble(amount),
                    description
            );
        } catch (ParseException e) {
            Log.d("Error", e.getMessage());
            return false;
        }
        return App.dbcontext.add(Bill);
    }
}