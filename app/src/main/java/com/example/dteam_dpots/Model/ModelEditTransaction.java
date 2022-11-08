package com.example.dteam_dpots.Model;
import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.Base.*;

import java.util.Date;
import java.util.List;

public class ModelEditTransaction extends Model {
    private Bill bill;
    private List<PotItem> listPotItem;

    public Bill getBill(String pillID) {
        if(bill == null) {
            bill = App.dbcontext.getBill(pillID);
        }
        return bill;
    }

    public String dateDdMmYyyy(Date date) {
        return App.format.dateDdMmYyyy(date);
    }

    public List<PotItem> GetPotItems() {
        this.listPotItem = App.dbcontext.getPotItem();
        return this.listPotItem;
    }

    public boolean updateBill(String idItem, String currentcy, String date, String description) {
        this.bill.setCurrency(Double.parseDouble(currentcy));
        this.bill.setDescription(description);
        this.bill.setID_Pottem(idItem);
        try {
            bill.setDate(App.format.getDateDdMmYyyy(date));
        } catch (Exception e) {
            return false;
        }
        return App.dbcontext.Update(this.bill);
    }

    public String formatCurrency(Double currency) {
        return App.format.doubleToMoneyVND(currency);
    }
}