package com.example.dteam_dpots.Beans;

import java.util.List;

public class Pottem {
    private String ID;
    private String Picture;
    private String Name;
    private List<Bill> ListBill;
    private List<PlanBill>ListPlanBill;

    public Pottem(String ID, String picture, String name) {
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

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
