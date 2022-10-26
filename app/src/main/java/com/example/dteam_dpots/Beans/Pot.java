package com.example.dteam_dpots.Beans;

import java.util.List;

public class Pot {
    private String ID;
    private String ID_Income;
<<<<<<< HEAD
    private int Perent;
    private List<Pottem>ListPottem;
    public Pot(String ID, String ID_Income, int perent) {
        this.ID = ID;
        this.ID_Income = ID_Income;
        Perent = perent;
=======
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
>>>>>>> 24bedac (Update setup Income)
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

    public int getPerent() {
        return Perent;
    }

    public void setPerent(int perent) {
        Perent = perent;
    }

    public List<Pottem> getListPottem() {
        return ListPottem;
    }

    public void setListPottem(List<Pottem> listPottem) {
        ListPottem = listPottem;
    }
}
