package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanTransaksiCustomerBulananResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanTransaksiCustomerBulanan> laporanTransaksiCustomerBulananList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanTransaksiCustomerBulanan> getLaporanTransaksiCustomerBulananList() {
        return laporanTransaksiCustomerBulananList;
    }

    public void setLaporanTransaksiCustomerBulananList(List<LaporanTransaksiCustomerBulanan> laporanTransaksiCustomerBulananList) {
        this.laporanTransaksiCustomerBulananList = laporanTransaksiCustomerBulananList;
    }
}
