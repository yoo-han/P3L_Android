package com.yohanhadiwijaya.ajrmobile.models;

public class LaporanDetailPendapatanBulanan {
    private String Nama_Customer;
    private String Nama_Mobil;
    private String Jenis_Transaksi;
    private int Jumlah_Transaksi;
    private float Pendapatan_Mobil;

    public LaporanDetailPendapatanBulanan(String nama_Customer, String nama_Mobil, String jenis_Transaksi, int jumlah_Transaksi, float pendapatan_Mobil) {
        Nama_Customer = nama_Customer;
        Nama_Mobil = nama_Mobil;
        Jenis_Transaksi = jenis_Transaksi;
        Jumlah_Transaksi = jumlah_Transaksi;
        Pendapatan_Mobil = pendapatan_Mobil;
    }

    public String getNama_Customer() {
        return Nama_Customer;
    }

    public void setNama_Customer(String nama_Customer) {
        Nama_Customer = nama_Customer;
    }

    public String getNama_Mobil() {
        return Nama_Mobil;
    }

    public void setNama_Mobil(String nama_Mobil) {
        Nama_Mobil = nama_Mobil;
    }

    public String getJenis_Transaksi() {
        return Jenis_Transaksi;
    }

    public void setJenis_Transaksi(String jenis_Transaksi) {
        Jenis_Transaksi = jenis_Transaksi;
    }

    public int getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }

    public void setJumlah_Transaksi(int jumlah_Transaksi) {
        Jumlah_Transaksi = jumlah_Transaksi;
    }

    public float getPendapatan_Mobil() {
        return Pendapatan_Mobil;
    }

    public void setPendapatan_Mobil(float pendapatan_Mobil) {
        Pendapatan_Mobil = pendapatan_Mobil;
    }
}
