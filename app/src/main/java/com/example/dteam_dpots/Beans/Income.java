package com.example.dteam_dpots.Beans;

import java.util.List;

public class Income {
    private String ID;
    private String ID_InComeRange;
    private Double amount;

    private List<Pot> ListPot ;
    public Income(String id, String id_InComeRange, Double amount) {
        this.amount = amount;
        this.ID_InComeRange = id_InComeRange;
        this.ID = id;
    }

    public Income() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_InComeRange() {
        return ID_InComeRange;
    }

    public void setID_InComeRange(String ID_InComeRange) {
        this.ID_InComeRange = ID_InComeRange;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Pot> getListPot() {
        return ListPot;
    }

    public void setListPot(List<Pot> listPot) {
        ListPot = listPot;
    }
}