package com.example.dteam_dpots.Beans;

import java.util.List;

public class Pot {
    private String ID;
    private String ID_Income;
    private String shortName;
    private String fullName;
    private String description;
    private int Percent;
    private List<PotItem>ListPottem;

    public Pot(String ID, String ID_Income, String shortName, String fullName, String description, int percent) {
        this.ID = ID;
        this.ID_Income = ID_Income;
        this.shortName = shortName;
        this.fullName = fullName;
        this.description = description;
        Percent = percent;
    }

    public Pot() {
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID_Income() {
        return ID_Income;
    }

    public void setID_Income(String ID_Income) {
        this.ID_Income = ID_Income;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercent() {
        return Percent;
    }

    public void setPercent(int percent) {
        Percent = percent;
    }

    public List<PotItem> getListPottem() {
        return ListPottem;
    }

    public void setListPottem(List<PotItem> listPottem) {
        ListPottem = listPottem;
    }
}