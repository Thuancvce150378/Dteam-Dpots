package com.example.dteam_dpots.Model;

public class SplashModel extends com.example.dteam_dpots.Base.Model {
    public SplashModel() {
        super();
    }

    public String getText() {
        return App.dbcontext.getText();
    }
}