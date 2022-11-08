package com.example.dteam_dpots.Model;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.dteam_dpots.Base.*;
import com.example.dteam_dpots.Beans.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModelHistoryPot extends Model {
    List<PotItem> PotItemList;
    List<Bill> BillList;
    public Collection AllDate;
    Pot pot;

    public Pot GetPot(String potName) {
        if (pot == null)
            pot = App.dbcontext.getPot(potName);
        return pot;
    }
    public boolean updatePot(){
        this.pot = App.dbcontext.getPot(this.pot.getShortName());
        return true;
    }

    public List<PotItem> GetAllPotItemList() {
            PotItemList = this.pot.getListPottem();
        return PotItemList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<PotItem> GetPotItem(String PotName) {
//        return pot.getListPottem().stream().filter(x -> x.getName().equals(PotName)).collect(Collectors.toList());
        return pot.getListPottem();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Bill> getBill(String filter) {
        List <Bill> bills = new ArrayList<>();
        if (filter.equals("All")) {
            //get all list bill
            //merge all list bill
            for (PotItem potItem : this.GetAllPotItemList()) {
                bills.addAll(potItem.getListBill());
            }
        } else {
            //get list bill by date
            for (PotItem potItem : this.GetAllPotItemList()) {
                bills.addAll(potItem.getListBill().stream().filter(bill -> GetPotItemName(bill.getID_Pottem()).equals(filter)).collect(Collectors.toList()));
            }
        }
        this.BillList = bills;
        return bills;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String GetPotItemName(String ID) {
        return PotItemList.stream().filter(potItem -> potItem.getID().equals(ID)).findFirst().get().getName();
    }

    public String doubleToMoneyVND(double d) {
        return App.format.doubleToMoneyVND(d);
    }

    public double getPotAmount() {
        Pot pot = this.pot;
        Income income = App.dbcontext.GetIncome();
        return income.getAmount() * pot.getPercent() / 100;
    }

    public double getPotBalance() {
        double balance = getPotAmount();
        for (PotItem potItem : pot.getListPottem()) {
            for (Bill bill : potItem.getListBill()) {
                balance -= bill.getCurrency();
            }

        }
        return balance;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean deleteBill(Bill bill) {
        boolean result = false;
        try{
            result = App.dbcontext.Delete(bill);
            if(result){
                this.BillList.remove(bill);
                this.pot.getListPottem().forEach(potItem -> {
                    potItem.getListBill().remove(bill);
                });
            }
        } catch (Exception e) {
            Log.d("Model history pot >> delete bill >>", e.getMessage());
        }
        return result;
    }
}