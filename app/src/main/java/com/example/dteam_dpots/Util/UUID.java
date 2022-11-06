package com.example.dteam_dpots.Util;

import com.example.dteam_dpots.Base.View;

public class UUID {
    public String genID(){
        return java.util.UUID.randomUUID().toString();
    }
}