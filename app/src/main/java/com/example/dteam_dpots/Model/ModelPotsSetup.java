package com.example.dteam_dpots.Model;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dteam_dpots.Beans.Pot;
import com.example.dteam_dpots.DatabaseContext.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ModelPotsSetup extends com.example.dteam_dpots.Base.Model {
    private Stack<Pot> listPot = new Stack<>();
    private final String ID_income = App.dbcontext.GetIncome().getID();

    public ModelPotsSetup() {
        super();
    }

    public int potSetup(String shortName, String fullName, String description, int percent) {
        try {

            if (listPot.size() < 6) {
                Pot pot = new Pot();
                pot.setID(App.uuid.genID());
                pot.setID_Income(ID_income);
                pot.setShortName(shortName);
                pot.setFullName(fullName);
                pot.setDescription(description);
                pot.setPercent(percent);
                listPot.add(pot);
            }
            return listPot.size();
        } catch (Exception e) {
            Log.d("Error >> ", e.getMessage());
        }
        return -1;

    }

    public int RemoveAtLast() {
        try {
            if (listPot.size() > 0) {
                listPot.pop();
                return listPot.size();
            }
        } catch (Exception e) {
            Log.d("Error >> ", e.getMessage());
        }
        return -1;
    }

    ;


    public Pot GetPot(int currentPot) {
        try {
            if (currentPot >= 0 && currentPot < listPot.size()) {
                return listPot.get(currentPot);
            }
        } catch (Exception e) {
            Log.d("Error >> ", e.getMessage());
        }
        return null;
    }

    public int getTotalPercent() {
        int total = 0;
        for (Pot pot : listPot) {
            Log.d("Pot >> ", pot.getShortName() + " : " + pot.getPercent());
            total += pot.getPercent();
        }
        Log.d("total", total + "");
        return total;
    }

    public boolean saveChange() throws Exception {
        App.dbcontext.GetIncome().setListPot(listPot); //still save to db
        App.dbcontext.UpdateListPot(this.listPot);

        //print list pot
        for (Pot pot : listPot) {
            Log.d("Pot >> ", pot.getShortName() + " : " + pot.getPercent());
        }
        return true;
    }
}