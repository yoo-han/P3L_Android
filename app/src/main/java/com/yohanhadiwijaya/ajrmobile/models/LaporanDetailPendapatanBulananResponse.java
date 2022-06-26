package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LaporanDetailPendapatanBulananResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<LaporanDetailPendapatanBulanan> laporanDetailPendapatanBulananList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LaporanDetailPendapatanBulanan> getLaporanDetailPendapatanBulananList() {
        return laporanDetailPendapatanBulananList;
    }

    public void setLaporanDetailPendapatanBulananList(List<LaporanDetailPendapatanBulanan> laporanDetailPendapatanBulananList) {
        this.laporanDetailPendapatanBulananList = laporanDetailPendapatanBulananList;
    }
}
