package com.example.dteam_dpots.Base;
import com.example.dteam_dpots.DpotsApp;
public class Model {
 public DpotsApp App;

 public boolean isSetup() {
    return App.dbcontext.isSetup();
 }
}