package com.example.dteam_dpots.Model;


import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dteam_dpots.Beans.Pot;
import com.example.dteam_dpots.Beans.PotItem;
import com.example.dteam_dpots.DatabaseContext.*;
import com.example.dteam_dpots.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
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


        Dictionary<String, List> potItemDictionary = new Hashtable<>();
        potItemDictionary.put(Default.POT_NEC_NAME, new ArrayList<PotItem>());
        potItemDictionary.put(Default.POT_EDU_NAME, new ArrayList<PotItem>());
        potItemDictionary.put(Default.POT_FFA_NAME, new ArrayList<PotItem>());
        potItemDictionary.put(Default.POT_GIVE_NAME, new ArrayList<PotItem>());
        potItemDictionary.put(Default.POT_LTS_NAME, new ArrayList<PotItem>());
        potItemDictionary.put(Default.POT_PLAY_NAME, new ArrayList<PotItem>());

        ArrayList<PotItem> NEC_ITEM = new ArrayList<PotItem>();
        ArrayList<PotItem> EDU_ITEM = new ArrayList<PotItem>();
        ArrayList<PotItem> FFA_ITEM = new ArrayList<PotItem>();
        ArrayList<PotItem> GIVE_ITEM = new ArrayList<PotItem>();
        ArrayList<PotItem> LTS_ITEM = new ArrayList<PotItem>();
        ArrayList<PotItem> PLAY_ITEM = new ArrayList<PotItem>();

        NEC_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.food, "Food"));
        NEC_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.clothes, "Clothes"));
        NEC_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.transport, "Transport"));
        NEC_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.health, "Health"));

        potItemDictionary.get(Default.POT_NEC_NAME).addAll(NEC_ITEM);

        EDU_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.school, "School"));
        EDU_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.university, "University"));

        potItemDictionary.get(Default.POT_EDU_NAME).addAll(EDU_ITEM);

        FFA_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.car, "Car"));
        FFA_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.house, "House"));

        potItemDictionary.get(Default.POT_FFA_NAME).addAll(FFA_ITEM);

        GIVE_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.charity, "Charity"));

        potItemDictionary.get(Default.POT_GIVE_NAME).addAll(GIVE_ITEM);

        LTS_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.travel, "Travel"));

        potItemDictionary.get(Default.POT_LTS_NAME).addAll(LTS_ITEM);

        PLAY_ITEM.add(new PotItem(App.uuid.genID(), R.drawable.entertainment, "Entertainment"));

        potItemDictionary.get(Default.POT_PLAY_NAME).addAll(PLAY_ITEM);


        //print list pot
        for (Pot pot : listPot) {
            Log.d("Pot >> ", pot.getShortName() + " : " + pot.getPercent());
            //add PotItem
            for (PotItem potItem : (ArrayList<PotItem>) potItemDictionary.get(pot.getShortName())) {
                potItem.setID_Pot(pot.getID());
            }
            pot.setListPottem(potItemDictionary.get(pot.getShortName()));
        }
        App.dbcontext.GetIncome().setListPot(listPot); //still save to db
        App.dbcontext.UpdateListPot(this.listPot);
        return true;
    }
}