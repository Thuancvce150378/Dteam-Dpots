package com.example.dteam_dpots.Beans;

public class PlanBill {

    private String ID;
    private String ID_Pottem;
    private Double Estimate;
    private String Description;

    public PlanBill(String ID, String ID_Pottem, Double estimate, String description) {
        this.ID = ID;
        this.ID_Pottem = ID_Pottem;
        Estimate = estimate;
        Description = description;
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

    public Double getEstimate() {
        return Estimate;
    }

    public void setEstimate(Double estimate) {
        Estimate = estimate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

