package com.example.dteam_dpots.Beans;

public class Income {
    private String IncomeWith;
    private Double amount;

    public Income(String incomeWith, Double amount) {
        IncomeWith = incomeWith;
        amount = amount;
    }

    //get set value
    public String getIncomeWith() {
        return IncomeWith;
    }

    public void setIncomeWith(String incomeWith) {
        IncomeWith = incomeWith;
    }

    public Double getamount() {
        return amount;
    }

    public void setamount(Double amount) {
        amount = amount;
    }
}

