package com.anhtam.tikihome.model;

import com.anhtam.tikihome.base.Constant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badge {
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("option")
    @Expose
    private String option;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text != null ? text : "";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOption() {
        return option != null ? option : "";
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isHasTikiNow (){
        return code != null && code.equals(Constant.TIKI_NOW);
    }

    public boolean isHasFastDelivery (){
        return code != null && code.equals(Constant.FAST_DELIVERY);
    }

    public boolean isHasOptionColor (){
        return code != null && code.equals(Constant.OPTION_COLOR);
    }

    public String getDeliveryText (){
        return isHasFastDelivery() ? getText() : null;
    }

    public String getDeliveryNumber (){
        return isHasFastDelivery() ? getOption() : null;
    }
}
