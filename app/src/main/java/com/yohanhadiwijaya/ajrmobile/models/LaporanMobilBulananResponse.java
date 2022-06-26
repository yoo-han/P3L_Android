package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanMobilBulananResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanMobilBulanan> laporanMobilBulananList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanMobilBulanan> getLaporanMobilBulananList() {
        return laporanMobilBulananList;
    }

    public void setLaporanMobilBulananList(List<LaporanMobilBulanan> laporanMobilBulananList) {
        this.laporanMobilBulananList = laporanMobilBulananList;
    }
}
