package com.example.dteam_dpots.Beans;

import java.util.List;

public class PotItem {
    private String ID;
    private int Picture;
    private String Name;
    private String ID_Pot;
    private Pot pot;
    private List<Bill> ListBill;
    private List<PlanBill>ListPlanBill;

    public PotItem(String ID, int picture, String name, String ID_Pot, Pot pot) {
        this.ID = ID;
        Picture = picture;
        Name = name;
        this.ID_Pot = ID_Pot;
        this.pot = pot;
    }

    public PotItem(String ID, int picture, String name, String ID_Pot) {
        this.ID = ID;
        Picture = picture;
        Name = name;
        this.ID_Pot = ID_Pot;
    }

    public PotItem(String ID, int picture, String name) {
        this.ID = ID;
        Picture = picture;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getPicture() {
        return Picture;
    }

    public void setPicture(int picture) {
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID_Pot() {
        return ID_Pot;
    }

    public void setID_Pot(String ID_Pot) {
        this.ID_Pot = ID_Pot;
    }

    public Pot getPot() {
        return pot;
    }

    public void setPot(Pot pot) {
        this.pot = pot;
    }

    public List<Bill> getListBill() {
        return ListBill;
    }

    public void setListBill(List<Bill> listBill) {
        ListBill = listBill;
    }

    public List<PlanBill> getListPlanBill() {
        return ListPlanBill;
    }

    public void setListPlanBill(List<PlanBill> listPlanBill) {
        ListPlanBill = listPlanBill;
    }
}