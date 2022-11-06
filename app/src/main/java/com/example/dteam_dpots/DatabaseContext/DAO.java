package com.example.dteam_dpots.DatabaseContext;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dteam_dpots.Beans.*;

import com.example.dteam_dpots.Beans.Income;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dteam_dpots.Util.*;

public class DAO extends SQLiteOpenHelper {
    //cau lenh query excute sql
    public DAO(Context context) {
        super(context, "DB4.db", null, 1);
    }

    /*Create Database*/
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table tpPlanBill( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_PotItem  TEXT  NOT NULL," +
                "estiminate REAL  NOT NULL," +
                "isCheck INTERGER  NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (ID_PotItem) REFERENCES tbPotItem(ID)" +
                ")");

        DB.execSQL("create Table tbPot( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "percent INTEGER  NOT NULL," +
                "ID_Income TEXT NOT NULL," +
                "short_name TEXT NOT NULL," +
                "full_name TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (ID_Income) REFERENCES tbIncome(ID)" +
                ")");

        DB.execSQL("create Table tbInCome( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_IncomeRange TEXT NOT NULL," +
                "amount INTEGER NOT NULL," +
                "FOREIGN KEY (ID_IncomeRange) REFERENCES tbIncomeRange(ID)" +
                ")");

        DB.execSQL("create Table tbPotItem( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_Pot TEXT NOT NULL," +
                "picture INTEGER NOT NULL," +
                "text TEXT NOT NULL," +
                "FOREIGN KEY (ID_Pot) REFERENCES tbPot(ID)" +
                ")");

        DB.execSQL("create Table tbBill( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "ID_PotItem TEXT  NOT NULL," +
                "date TEXT  NOT NULL," +
                "currency REAL NOT NULL," +
                "description TEXT NOT NULL," +
                "FOREIGN KEY (ID_PotItem) REFERENCES tbPotItem(ID)" +
                ")");

        DB.execSQL("create Table tbIncomeRange( " +
                "ID TEXT PRIMARY KEY NOT NULL," +
                "name TEXT NOT NULL" +
                ")");
    }

    /*Update Database*/
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists tpPlanBill");
        DB.execSQL("drop Table if exists tbPot");
        DB.execSQL("drop Table if exists tbInCome");
        DB.execSQL("drop Table if exists tbPotItem");
        DB.execSQL("drop Table if exists tbBill");
        DB.execSQL("drop Table if exists tbIncomeRange");
    }

    /*InsertIncome*/
    public Boolean insertInCome(Income income) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", income.getID());
        contentValues.put("ID_IncomeRange", income.getID_InComeRange());
        contentValues.put("amount", income.getAmount());

        long result = DB.insert("tbInCome", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*GetIncome*/
    public Income getIncome() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from tbInCome", null);
        Income income = new Income();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            income.setID(cursor.getString(0));
            income.setID_InComeRange(cursor.getString(1));
            income.setAmount(cursor.getDouble(2));
        } else {
            return null;
        }
        return income;
    }

    /*Get List InComeRange*/
    @SuppressLint("Range")
    public List<IncomeRange> getListIncomeRange() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("SELECT * FROM tbIncomeRange", null);
        if (c == null) {
            return null;
        } else {
            List<IncomeRange> incomeRangeList = new ArrayList<>();
            while (c.moveToNext()) {
                IncomeRange incomeRange = new IncomeRange(c.getString(c.getColumnIndex("ID"))
                        , c.getString(c.getColumnIndex("name")));
                incomeRangeList.add(incomeRange);
            }
            return incomeRangeList;
        }
    }

    /*Get List Bill*/
    @SuppressLint("Range")
    public List<Bill> getListBill() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("SELECT * FROM tbBill", null);
        if (c == null) {
            return null;
        } else {
            List<Bill> billList = new ArrayList<>();
            while (c.moveToNext()) {
                Bill bill = new Bill(c.getString(c.getColumnIndex("ID"))
                        , c.getString(c.getColumnIndex("ID_PotItem"))
                        , new Date(c.getString(c.getColumnIndex("date")))
                        , c.getDouble(c.getColumnIndex("currency"))
                        , c.getString(c.getColumnIndex("description"))
                );
                billList.add(bill);
            }
            return billList;
        }
    }
    public List<Bill> getListBill(String idPotItem) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("SELECT * FROM tbBill WHERE ID_PotItem = ?", new String[]{idPotItem});
        if (c == null) {

            return null;
        } else {
            List<Bill> billList = new ArrayList<>();
            while (c.moveToNext()) {
                @SuppressLint("Range") Bill bill = new Bill(c.getString(c.getColumnIndex("ID"))
                        , c.getString(c.getColumnIndex("ID_PotItem"))
                        , new Date(c.getString(c.getColumnIndex("date")))
                        , c.getDouble(c.getColumnIndex("currency"))
                        , c.getString(c.getColumnIndex("description"))
                );
                billList.add(bill);
            }
            java.sql.Date date = java.sql.Date.valueOf("2020-01-01");
            java.sql.Date date1 = java.sql.Date.valueOf("2020-01-02");
            billList.add(new Bill("0", idPotItem, date, 0D, "0"));
            billList.add(new Bill("1", idPotItem, date, 0D, "0"));
            billList.add(new Bill("2", idPotItem, date, 0D, "0"));
            billList.add(new Bill("3", idPotItem, date, 0D, "0"));
            billList.add(new Bill("4", idPotItem, date1, 1D, "1"));
            billList.add(new Bill("5", idPotItem, date1, 1D, "1"));
            billList.add(new Bill("6", idPotItem, date1, 1D, "1"));
            billList.add(new Bill("7", idPotItem, date1, 1D, "1"));
            billList.add(new Bill("8", idPotItem, date1, 1D, "1"));


            return billList;
        }
    }

    /*Insert Bill*/
    public Boolean insertInComeRange(String ID, String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("ID", ID);
        long result = DB.insert("tbIncomeRange", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*Insert Bill*/
    public Boolean insertBill(String ID, String ID_Pottem, Date Date, Double Currency, String Description) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("ID_PotItem", ID_Pottem);
        contentValues.put("date", String.valueOf(Date));
        contentValues.put("currency", Currency);
        contentValues.put("description", Description);

        long result = DB.insert("tbBill", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*Delete Bill*/
    public Boolean deleteBill(String ID) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from tbBill where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = DB.delete("tbBill", "ID=?", new String[]{ID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /*Delete Bill*/
    public Boolean updateBill(String ID, Date Date, Double Currency, String Description) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", ID);
        contentValues.put("date", String.valueOf(Date));
        contentValues.put("currency", Currency);
        contentValues.put("description", Description);
        Cursor cursor = DB.rawQuery("Select * from tbBill where ID = ?", new String[]{ID});
        if (cursor.getCount() > 0) {
            long result = DB.update("tbBill", contentValues, "name=?", new String[]{ID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void updateListPot(List<Pot> listPot) throws Exception {
        SQLiteDatabase DB = this.getWritableDatabase();

        //remove all row in table tbPot
        Log.d("updateListPot", "remove all row in table tbPot");
        DB.execSQL("delete from tbPotItem");
        DB.execSQL("delete from tbPot");
        for (Pot pot : listPot) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("ID", pot.getID());
            contentValues.put("percent", pot.getPercent());
            contentValues.put("ID_Income", pot.getID_Income());
            contentValues.put("short_name", pot.getShortName());
            contentValues.put("full_name", pot.getFullName());
            contentValues.put("description", pot.getDescription());
            DB.insert("tbPot", null, contentValues);
            for (PotItem potItem : pot.getListPottem()) {
                contentValues = new ContentValues();
                contentValues.put("ID", potItem.getID());
                contentValues.put("ID_Pot", pot.getID());
                contentValues.put("text", potItem.getName());
                contentValues.put("picture", potItem.getPicture());
                DB.insert("tbPotItem", null, contentValues);
            }
        }
        Log.d("updateListPot", "updateListPot success");
    }

    public List<Pot> getListPot() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("SELECT * FROM tbPot", null);
        if (c == null) {
            return null;
        } else {
            List<Pot> potList = new ArrayList<>();
            while (c.moveToNext()) {
                @SuppressLint("Range") Pot Pot = new Pot(
                        c.getString(c.getColumnIndex("ID"))
                        , c.getString(c.getColumnIndex("ID_Income"))
                        , c.getString(c.getColumnIndex("short_name"))
                        , c.getString(c.getColumnIndex("full_name"))
                        , c.getString(c.getColumnIndex("description"))
                        , c.getInt(c.getColumnIndex("percent"))
                );
                potList.add(Pot);
            }
            return potList;
        }
    }

    public void insertPotItem(String id, int picture, String name, String id_pot) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("picture", picture);
        contentValues.put("name", name);
        contentValues.put("ID_Pot", id_pot);
        DB.insert("tbPotItem", null, contentValues);
    }

    public void updateListPotItem(List<Pot> listPot) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //remove all row in table tbPotItem
        Log.d("updateListPotItem", "remove all row in table tbPotItem");
        DB.execSQL("delete from tbPotItem");
        for (Pot pot : listPot) {
            for (PotItem potItem : pot.getListPottem()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ID", potItem.getID());
                contentValues.put("picture", potItem.getPicture());
                contentValues.put("name", potItem.getName());
                contentValues.put("ID_Pot", pot.getID());
                DB.insert("tbPotItem", null, contentValues);
            }
        }
        Log.d("updateListPotItem", "updateListPotItem success");
    }

    public ArrayList<PotItem> getListPotItem(String Potname) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //get id from pot name
        Cursor c = DB.rawQuery("SELECT * FROM tbPot where short_name = ?", new String[]{Potname});

        if (c == null) {
            return null;
        } else {
            c.moveToFirst();
            @SuppressLint("Range") String id = c.getString(c.getColumnIndex("ID"));
            c = DB.rawQuery("SELECT * FROM tbPotItem where ID_Pot = ?", new String[]{id});
            ArrayList<PotItem> potItemList = new ArrayList<>();
            while (c.moveToNext()) {
                @SuppressLint("Range") PotItem PotItem = new PotItem(
                        c.getString(c.getColumnIndex("ID"))
                        , c.getInt(c.getColumnIndex("picture"))
                        , c.getString(c.getColumnIndex("text"))
                        , c.getString(c.getColumnIndex("ID_Pot"))
                );
                PotItem.setListBill(getListBill(PotItem.getID()));
                potItemList.add(PotItem);
            }
            return potItemList;
        }
        }

    public Pot getPot(String potName) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("SELECT * FROM tbPot where short_name = ?", new String[]{potName});
        if (c == null) {
            return null;
        } else {
            c.moveToFirst();
            @SuppressLint("Range") Pot Pot = new Pot(
                    c.getString(c.getColumnIndex("ID"))
                    , c.getString(c.getColumnIndex("ID_Income"))
                    , c.getString(c.getColumnIndex("short_name"))
                    , c.getString(c.getColumnIndex("full_name"))
                    , c.getString(c.getColumnIndex("description"))
                    , c.getInt(c.getColumnIndex("percent"))
            );
            Pot.setListPottem(getListPotItem(Pot.getShortName()));
            return Pot;
        }
    }
}