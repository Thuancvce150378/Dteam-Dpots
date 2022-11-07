package com.example.dteam_dpots.ItemView;

public class CustomSpinnerItemAdd {
    private String spinnerItemName;
    private int spinnerItemImage;
    private String spinnerItemDesc;
    private String id_ItemPot;

    public CustomSpinnerItemAdd(String spinnerItemName, int spinnerItemImage, String spinnerItemDesc, String id_itemPot) {
        this.spinnerItemName = spinnerItemName;
        this.spinnerItemImage = spinnerItemImage;
        this.spinnerItemDesc = spinnerItemDesc;
        id_ItemPot = id_itemPot;
    }

    public String getSpinnerItemName() {
        return spinnerItemName;
    }

    public int getSpinnerItemImage() {
        return spinnerItemImage;
    }

    public String getSpinnerItemDesc() { return spinnerItemDesc;}

    public String getId_ItemPot() {
        return id_ItemPot;
    }
}