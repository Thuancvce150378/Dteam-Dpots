package com.example.dteam_dpots.DatabaseContext;
import com.example.dteam_dpots.Beans.*;

import com.example.dteam_dpots.Beans.Income;

import java.util.Arrays;
import java.util.List;

public class DAO {
//cau lenh query excute sql
    public DAO() {
    }

<<<<<<< HEAD
    public List<Income> getIncomeList() {
        Income[] incomeList = {new Income("Month", 1000D), new Income("Month", 2000D), new Income("Month", 3000D)};
        return Arrays.asList(incomeList);
=======
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
                "picture TEXT NOT NULL," +
                "text TEXT NOT NULL" +
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
                /*private String ID;
    private String ID_Income;
    private String shortName;
    private String fullName;
    private String description;
    private int Percent;*/
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
>>>>>>> 24bedac (Update setup Income)
    }
}