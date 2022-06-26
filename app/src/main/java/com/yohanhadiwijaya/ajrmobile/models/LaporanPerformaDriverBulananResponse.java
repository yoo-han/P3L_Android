package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanPerformaDriverBulananResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanPerformaDriverBulanan> laporanPerformaDriverBulananList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanPerformaDriverBulanan> getLaporanPerformaDriverBulananList() {
        return laporanPerformaDriverBulananList;
    }

    public void setLaporanPerformaDriverBulananList(List<LaporanPerformaDriverBulanan> laporanPerformaDriverBulananList) {
        this.laporanPerformaDriverBulananList = laporanPerformaDriverBulananList;
    }
}
