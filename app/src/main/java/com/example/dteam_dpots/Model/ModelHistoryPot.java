package com.example.dteam_dpots.Model;
import com.example.dteam_dpots.Base.*;
import com.example.dteam_dpots.Beans.*;

import java.util.ArrayList;
import java.util.List;

public class ModelHistoryPot extends Model {



private String potName;
private String potAmount;
private String potBalance;
public List<PotItem> potItem ;

public ArrayList<PotItem> GetPotItem(String Potname){
    return App.dbcontext.getPotItem(Potname);
}
}