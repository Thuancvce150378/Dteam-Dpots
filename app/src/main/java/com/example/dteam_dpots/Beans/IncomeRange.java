package com.example.dteam_dpots.Beans;

import java.util.List;

public class IncomeRange {

    private String ID;
    private String ID_InCome;
    private Double Name;

    public IncomeRange(String ID, String ID_InCome, Double name) {
        this.ID = ID;
        this.ID_InCome = ID_InCome;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_InCome() {
        return ID_InCome;
    }

    public void setID_InCome(String ID_InCome) {
        this.ID_InCome = ID_InCome;
    }

    public Double getName() {
        return Name;
    }

    public void setName(Double name) {
        Name = name;
    }

}
