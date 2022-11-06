package com.example.dteam_dpots;
import com.example.dteam_dpots.DatabaseContext.DBContext;
import com.example.dteam_dpots.Util.*;
public class DpotsApp extends android.app.Application {
   public static DBContext dbcontext;
   public static UUID uuid;
    public static Format format;
    public DpotsApp() {
        super();
         dbcontext = new DBContext(this);
        uuid = new UUID();
        format = new Format();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}