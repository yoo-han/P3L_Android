package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MobilResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<Mobil> mobilList;

    public String getMessage(){
        return message;
    }

    public List<Mobil> getMobilList() {
        return mobilList;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
