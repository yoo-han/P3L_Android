package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTransaksiDriverBulananResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanTransaksiDriverBulanan> laporanTransaksiDriverBulananList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanTransaksiDriverBulanan> getLaporanTransaksiDriverBulananList() {
        return laporanTransaksiDriverBulananList;
    }

    public void setLaporanTransaksiDriverBulananList(List<LaporanTransaksiDriverBulanan> laporanTransaksiDriverBulananList) {
        this.laporanTransaksiDriverBulananList = laporanTransaksiDriverBulananList;
    }
}
