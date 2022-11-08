package com.example.dteam_dpots.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {
    //double to unit money vietnam
    public String doubleToMoneyVND(double d) {
        return String.format("%,.0f", d);
    }
    public String dateDdMmYyyy(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
    public Date getDateDdMmYyyy(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }
}