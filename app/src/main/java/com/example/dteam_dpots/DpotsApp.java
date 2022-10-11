package com.example.dteam_dpots;
import com.example.dteam_dpots.DatabaseContext.DBContext;
public class DpotsApp extends android.app.Application {
   public static DBContext dbcontext;

    public DpotsApp() {
        super();
         dbcontext = new DBContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}