package com.example.dteam_dpots.Beans;

import java.util.List;

public class IncomeRange {

    private String ID;
    private String Name;

    public IncomeRange(String id, String name) {
        ID = id;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
