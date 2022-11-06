package com.example.dteam_dpots.Model;
import com.example.dteam_dpots.Base.Model;
import com.example.dteam_dpots.Beans.*;
public class ModelHome extends Model {
    public Income income;
    public double balance;
    public ModelHome() {
        super();
        income = App.dbcontext.GetIncome();
        balance = income.getAmount() - App.dbcontext.GetBalance();
    }
    public Income getIncome() {
        return App.dbcontext.GetIncome();
    }

    //get balance amount
    public double getBalance() {
        return App.dbcontext.GetBalance();
    }

    //double to unit money vietnam
    public String doubleToMoneyVND(double d) {
        return App.format.doubleToMoneyVND(d);
    }

}