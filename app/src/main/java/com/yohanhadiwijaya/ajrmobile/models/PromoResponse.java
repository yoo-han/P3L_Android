package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PromoResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Promo> promoList;

    public String getMessage(){
        return message;
    }

    public List<Promo> getPromoList() {
        return promoList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
