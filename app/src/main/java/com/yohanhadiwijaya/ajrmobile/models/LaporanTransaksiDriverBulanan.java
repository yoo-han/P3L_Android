package com.yohanhadiwijaya.ajrmobile.models;

public class LaporanTransaksiDriverBulanan {
    private String ID_Driver;
    private String Nama_Driver;
    private int Jumlah_Transaksi;

    public LaporanTransaksiDriverBulanan(String ID_Driver, String nama_Driver, int jumlah_Transaksi) {
        this.ID_Driver = ID_Driver;
        Nama_Driver = nama_Driver;
        Jumlah_Transaksi = jumlah_Transaksi;
    }

    public String getID_Driver() {
        return ID_Driver;
    }

    public void setID_Driver(String ID_Driver) {
        this.ID_Driver = ID_Driver;
    }

    public String getNama_Driver() {
        return Nama_Driver;
    }

    public void setNama_Driver(String nama_Driver) {
        Nama_Driver = nama_Driver;
    }

    public int getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }

    public void setJumlah_Transaksi(int jumlah_Transaksi) {
        Jumlah_Transaksi = jumlah_Transaksi;
    }
}
