package com.example.dteam_dpots.Util;

public class Format {
    //double to unit money vietnam
    public String doubleToMoneyVND(double d) {
        return String.format("%,.0f", d);
    }
}