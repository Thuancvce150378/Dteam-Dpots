package com.example.dteam_dpots.Model;
import android.util.Log;

import com.example.dteam_dpots.Base.Model;
import com.example.dteam_dpots.Beans.*;
import com.example.dteam_dpots.DatabaseContext.DBContext;

import java.util.List;

public class ModelSetupIncome extends Model {
    public ModelSetupIncome() {
        super();
    }

    public void AddIncome(String incomeWith, Double amount) {

        //get list InComeRange
        List<IncomeRange> incomeRangeList = App.dbcontext.GetListIncomeRangeList();

        //get id incomerange
        String idIncomeRange = "";
        for (IncomeRange a:
             incomeRangeList) {
            if(incomeWith.equals(a.getName())){
                idIncomeRange = a.getID();
            }
        }

        //add income
        Income income = new Income(App.uuid.genID(),idIncomeRange,amount);
        App.dbcontext.add(income);
    }
}