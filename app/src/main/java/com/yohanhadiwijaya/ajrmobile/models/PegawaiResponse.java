package com.yohanhadiwijaya.ajrmobile.models;

import com.google.gson.annotations.SerializedName;

public class PegawaiResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Pegawai pegawai;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }
}
