package com.example.dteam_dpots.ItemView;

public class CustomSpinnerItemAdd {
    private String spinnerItemName;
    private int spinnerItemImage;
    private String spinnerItemDesc;

    public CustomSpinnerItemAdd(String spinnerItemName, int spinnerItemImage, String spinnerItemDesc) {
        this.spinnerItemName = spinnerItemName;
        this.spinnerItemImage = spinnerItemImage;
        this.spinnerItemDesc = spinnerItemDesc;
    }

    public String getSpinnerItemName() {
        return spinnerItemName;
    }

    public int getSpinnerItemImage() {
        return spinnerItemImage;
    }

    public String getSpinnerItemDesc() { return spinnerItemDesc;}
}
