package com.example.dteam_dpots.DatabaseContext;

import com.example.dteam_dpots.Beans.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//quan ly cac su kien cua object
public class DBContext {
    DAO cn;
    List<Income> incomeList = new ArrayList<Income>();
<<<<<<< HEAD
=======
    List<IncomeRange> incomeRangeList = new ArrayList<>();
    List<Pot> Pots = new ArrayList<>();
>>>>>>> 24bedac (Update setup Income)

    //constructor
    public DBContext() {
        cn = new DAO();
        loadingIncome();
    }

    public <T> void add(T value) {
        switch (value.getClass().getSimpleName()) {
            case "Income":
                incomeList.add((Income) value);
                break;
        }

    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    private void loadingIncome() {
        incomeList = cn.getIncomeList();
    }

    //get text
    public String getText() {
         String text = "Wellcome to Dpots"; //value get from DAO
        return text;
    }


<<<<<<< HEAD
=======
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
        Income income= this.GetIncome();
        List<Pot> pots = this.GetListPot();
            return income!=null && pots.size()>0;
    }


>>>>>>> 24bedac (Update setup Income)
}