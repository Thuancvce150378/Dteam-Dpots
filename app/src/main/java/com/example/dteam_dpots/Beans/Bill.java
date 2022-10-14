package com.example.dteam_dpots.Beans;

import java.util.Date;

public class Bill {
    private String ID;
    private String ID_Pottem;
    private Date Date;
    private Double Currency;
    private String Description;

    public Bill(String ID, String ID_Pottem, Date date, Double currency, String description) {
        this.ID = ID;
        this.ID_Pottem = ID_Pottem;
        Date = date;
        Currency = currency;
        Description = description;
    }

    public Bill() {
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
