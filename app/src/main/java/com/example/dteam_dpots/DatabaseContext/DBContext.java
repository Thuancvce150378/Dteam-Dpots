package com.example.dteam_dpots.DatabaseContext;

import android.util.Log;

import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.DpotsApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//quan ly cac su kien cua object
public class DBContext {
    DAO cn;
    List<Income> incomeList = new ArrayList<Income>();
    List<IncomeRange> incomeRangeList = new ArrayList<>();
    List<Pot> Pots = new ArrayList<>();

    public DBContext(DpotsApp dpotsApp) {
        cn = new DAO(dpotsApp);
    }

    public <T> boolean add(T value) {
        Log.d("DBContext", "DBContext");
        switch (value.getClass().getSimpleName()) {
            case "Income":
                Income income = (Income) value;
                if (cn.insertInCome(income))
                    return true;
                break;
            case "IncomeRange":
                IncomeRange incomeRange = (IncomeRange) value;
                if (cn.insertInComeRange(incomeRange.getID(), incomeRange.getName()))
                    return true;
                break;
            case "Bill":
                Bill bill = (Bill) value;
                if (cn.insertBill(bill.getID(), bill.getID_Pottem(), bill.getDate(), bill.getCurrency(), bill.getDescription()))
                    return true;
                break;
        }
        return false;
    }

    public <T> boolean Delete(T value) {
        switch (value.getClass().getSimpleName()) {
            case "Bill":
                Bill bill = (Bill) value;
                if (cn.deleteBill(bill.getID()))
                    return true;
                break;
        }
        return false;
    }

    public <T> void Update(T value) {
        switch (value.getClass().getSimpleName()) {
            case "Bill":
                Bill bill = (Bill) value;
                if (cn.updateBill(bill.getID(), bill.getDate(), bill.getCurrency(), bill.getDescription()))
                    Log.d("CONSOLE", "Update thanh cong");
                else Log.d("CONSOLE", "Update that bai");
                break;
        }
    }

    public List<Bill> GetListBill() {
        List<Bill> billList = cn.getListBill();
        return billList;
    }

    public List<IncomeRange> GetListIncomeRangeList() {
        List<IncomeRange> incomeRangeList = cn.getListIncomeRange();
        Log.d("GetListIncomeRangeList", "GetListIncomeRangeList");
        return incomeRangeList;
    }

    /*Income*/
    public Income GetIncome() {
        Income income = cn.getIncome();
        return income;
    }

    public void UpdateListPot(List<Pot> listPot) throws Exception {
        //update list pot to database
        cn.updateListPot(listPot);
    }

    public List<Pot> GetListPot() {
        return cn.getListPot();
    }

    public boolean isSetup() {
        Income income = this.GetIncome();
        List<Pot> pots = this.GetListPot();
        int totalPercent = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            totalPercent = pots.stream().mapToInt(Pot::getPercent).sum();
        } else {
            for (Pot pot : pots) {
                totalPercent += pot.getPercent();
            }
        }
        return income!= null && income.getAmount() > 0 && totalPercent == 100;
    }


    public double GetBalance() {
        double balance = 0;
        List<Bill> bills = this.GetListBill();
        for (Bill bill : bills) {
            balance += bill.getCurrency();
        }
        return balance;
    }

//    public List<PotItem> getPotItem(Pot pot) {
//        List<PotItem> potItemList = pot.getListPottem();
//        return potItemList;
//    }

    /*private String ID;
        private String Picture;
        private String Name;
        private String ID_Pot;*/
    public void addPotItem(PotItem potItem) {
        cn.insertPotItem(potItem.getID(), potItem.getPicture(), potItem.getName(), potItem.getID_Pot());
    }

    public Pot getPot(String potName) {
        return cn.getPotWithName(potName);
    }

    public boolean deleteBill(Bill pill) {
        return cn.deleteBill(pill.getID());
    }

    public List<PotItem> getPotItem() {
        return cn.getListPotItem();
    }
}