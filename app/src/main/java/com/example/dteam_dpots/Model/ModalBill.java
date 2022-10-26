package com.example.dteam_dpots.Model;
import com.example.dteam_dpots.Base.*;
import com.example.dteam_dpots.Beans.*;

import java.util.Date;
import java.util.List;

public class ModalBill extends Model{
    public ModalBill() {
        super();
    }

    public void addBill(Double Currency, String Description,Date Date){
        Bill bill = new Bill(App.uuid.genID(),"Temp ID",Date,Currency,Description);
        App.dbcontext.add(bill);
    }

    public void deleteBill(String ID){
        Bill bill = new Bill();
        bill.setID(ID);
        App.dbcontext.Delete(bill);
    }

    public void updateBill(String ID, String ID_Pottem, Date date, Double currency, String description){
        Bill bill = new Bill(ID,ID_Pottem,date,currency,description);
        App.dbcontext.Update(bill);
    }

    public List<Bill> getListBill(){
       return App.dbcontext.GetListBill();
    }

}
