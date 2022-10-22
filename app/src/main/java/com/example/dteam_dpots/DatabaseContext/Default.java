package com.example.dteam_dpots.DatabaseContext;

public class Default {
    public static final String DB_NAME = "dpots.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_POT = "pot";
    public static final String TABLE_POTITEM = "potItem";
    public static final String TABLE_INCOME = "income";
    public static final String TABLE_BILL = "bill";

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ID_POT = "ID_Pot";
    public static final String COLUMN_ID_INCOME = "ID_Income";
    public static final String COLUMN_ID_BILL = "ID_Bill";
    public static final String COLUMN_SHORTNAME = "ShortName";
    public static final String COLUMN_FULLNAME = "FullName";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_PERCENT = "Percent";
    public static final String COLUMN_DATE = "Date";
    public static final String COLUMN_CURRENCY = "Currency";

    public static final String POT_NEC_NAME = "NEC";
    public static final String POT_LTS_NAME = "LTS";
    public static final String POT_EDU_NAME = "EDU";
    public static final String POT_PLAY_NAME = "PLAY";
    public static final String POT_FFA_NAME = "FFA";
    public static final String POT_GIVE_NAME = "GIVE";

    public static  final String POT_NEC_NAME_FULL = "Neccessities";
    public static  final String POT_LTS_NAME_FULL = "Long Term Savings";
    public static  final String POT_EDU_NAME_FULL = "Education";
    public static  final String POT_PLAY_NAME_FULL = "Play";
    public static  final String POT_FFA_NAME_FULL = "Free For All";
    public static  final String POT_GIVE_NAME_FULL = "Give";

    public static final String INCOME_RANGE_NAME_MONTH = "Month";
    public static final String INCOME_RANGE_NAME_WEEK = "Week";

    public static final String POT_NEC_DESCRIPTION = "Food, water, shelter, clothing, transportation, etc.";
    public static final String POT_LTS_DESCRIPTION = "Emergency fund, retirement, etc.";
    public static final String POT_EDU_DESCRIPTION = "College, trade school, etc.";
    public static final String POT_PLAY_DESCRIPTION = "Vacation, hobbies, etc.";
    public static final String POT_FFA_DESCRIPTION = "Whatever you want!";
    public static final String POT_GIVE_DESCRIPTION = "Charity, tithing, etc.";

    public static final String[][] POT_ITEMS_NEC = {
            {"Food", "Food"},
            {"Water", "Water"},
            {"Shelter", "Shelter"},
            {"Clothing", "Clothing"},
            {"Transportation", "Transportation"},
            {"Health", "Health"},
            {"Insurance", "Insurance"},
            {"Utilities", "Utilities"},
            {"Misc", "Misc"}
    };
    public static final String[][] POT_ITEMS_LTS = {
            {"Emergency Fund", "Emergency Fund"},
            {"Retirement", "Retirement"},
            {"Misc", "Misc"}
    };
    public static final String[][] POT_ITEMS_EDU = {
            {"College", "College"},
            {"Trade School", "Trade School"},
            {"Misc", "Misc"}
    };
    public static final String[][] POT_ITEMS_PLAY = {
            {"Vacation", "Vacation"},
            {"Hobbies", "Hobbies"},
            {"Misc", "Misc"}
    };
    public static final String[][] POT_ITEMS_FFA = {
            {"Misc", "Misc"}
    };

}