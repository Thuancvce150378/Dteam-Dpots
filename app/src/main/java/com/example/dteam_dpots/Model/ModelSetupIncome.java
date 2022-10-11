package com.example.dteam_dpots.Model;
import com.example.dteam_dpots.Base.Model;
import com.example.dteam_dpots.Beans.*;

public class ModelSetupIncome extends Model {
    public ModelSetupIncome() {
        super();
    }

    public void AddIncome(String incomeWith, Double amount) {
        Income income = new Income(incomeWith, amount);
        App.dbcontext.add(income);
    }
}