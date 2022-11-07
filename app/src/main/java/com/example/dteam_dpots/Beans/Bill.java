package com.example.dteam_dpots.Beans;

import java.util.Date;

public class Bill {
    private String ID;
    private String ID_Pottem;
    private Date Date;
    private Double Currency;
    private String Description;

    private PotItem potItem;

    public Bill(String ID, String ID_Pottem, Date date, Double currency, String description) {
        this.ID = ID;
        this.ID_Pottem = ID_Pottem;
        Date = date;
        Currency = currency;
        Description = description;
    }

    public Bill(String ID, String ID_Pottem, java.util.Date date, Double currency, String description, PotItem potItem) {
        this.ID = ID;
        this.ID_Pottem = ID_Pottem;
        Date = date;
        Currency = currency;
        Description = description;
        this.potItem = potItem;
    }

    public Bill() {
    }

    public PotItem getPotItem() {
        return potItem;
    }

    public void setPotItem(PotItem potItem) {
        this.potItem = potItem;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_Pottem() {
        return ID_Pottem;
    }

    public void setID_Pottem(String ID_Pottem) {
        this.ID_Pottem = ID_Pottem;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Double getCurrency() {
        return Currency;
    }

    public void setCurrency(Double currency) {
        Currency = currency;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}