package com.example.dteam_dpots.DatabaseContext;

import android.util.Log;

import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.DpotsApp;

import java.util.ArrayList;
import java.util.List;
//quan ly cac su kien cua object
public class DBContext {
    DAO cn;
    List<Income> incomeList = new ArrayList<Income>();
    List<IncomeRange> incomeRangeList = new ArrayList<>();

    public DBContext(DpotsApp dpotsApp) {
        cn = new DAO(dpotsApp);
    }

    public <T> void add(T value) {
        Log.d("DBContext","DBContext");
        switch (value.getClass().getSimpleName()) {
            case "Income":
                Income income = (Income) value;
                if(cn.insertInCome(income))
                    Log.d("CONSOLE","ADD thanh cong");
                else    Log.d("CONSOLE","ADD that bai");
                break;
            case "IncomeRange":
                IncomeRange incomeRange = (IncomeRange) value;
                if(cn.insertInComeRange(incomeRange.getID(),incomeRange.getName()))
                    Log.d("CONSOLE","ADD thanh cong");
                else    Log.d("CONSOLE","ADD that bai");
                break;
            case "Bill":
                Bill bill = (Bill) value;
                if(cn.insertBill(bill.getID(), bill.getID_Pottem(), bill.getDate(),bill.getCurrency(), bill.getDescription()))
                    Log.d("CONSOLE","ADD thanh cong");
                else    Log.d("CONSOLE","ADD that bai");
                break;
        }
    }

    public <T> void Delete(T value) {
        switch (value.getClass().getSimpleName()) {
            case "Bill":
                Bill bill = (Bill) value;
                if(cn.deleteBill(bill.getID()))
                    Log.d("CONSOLE","Delete thanh cong");
                else    Log.d("CONSOLE","Delete that bai");
                break;
        }
    }

    public <T> void Update(T value) {
        switch (value.getClass().getSimpleName()) {
            case "Bill":
                Bill bill = (Bill) value;
                if(cn.updateBill(bill.getID(), bill.getDate(),bill.getCurrency(), bill.getDescription()))
                    Log.d("CONSOLE","Update thanh cong");
                else    Log.d("CONSOLE","Update that bai");
                break;
        }
    }

    public List<Bill> GetListBill() {
        List<Bill> billList = cn.getListBill();
        return billList;
    }

    public List<IncomeRange> GetListIncomeRangeList() {
        List<IncomeRange> incomeRangeList = cn.getListIncomeRange();
        Log.d("GetListIncomeRangeList","GetListIncomeRangeList");
        return incomeRangeList;
    }
}