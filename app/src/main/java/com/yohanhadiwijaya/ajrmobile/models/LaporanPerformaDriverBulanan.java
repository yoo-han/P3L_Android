package com.yohanhadiwijaya.ajrmobile.models;

public class LaporanPerformaDriverBulanan {
    private String ID_Driver;
    private String Nama_Driver;
    private int Jumlah_Transaksi;
    private float Rerata_Rating;

    public LaporanPerformaDriverBulanan(String ID_Driver, String nama_Driver, int jumlah_Transaksi, float rerata_Rating) {
        this.ID_Driver = ID_Driver;
        Nama_Driver = nama_Driver;
        Jumlah_Transaksi = jumlah_Transaksi;
        Rerata_Rating = rerata_Rating;
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

    public float getRerata_Rating() {
        return Rerata_Rating;
    }

    public void setRerata_Rating(float rerata_Rating) {
        Rerata_Rating = rerata_Rating;
    }
}
