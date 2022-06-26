package com.yohanhadiwijaya.ajrmobile.models;

public class LaporanTransaksiCustomerBulanan {

    private String Nama_Customer;
    private int Jumlah_Transaksi;

    public LaporanTransaksiCustomerBulanan(String nama_Customer, int jumlah_Transaksi) {
        Nama_Customer = nama_Customer;
        Jumlah_Transaksi = jumlah_Transaksi;
    }

    public String getNama_Customer() {
        return Nama_Customer;
    }

    public void setNama_Customer(String nama_Customer) {
        Nama_Customer = nama_Customer;
    }

    public int getJumlah_Transaksi() {
        return Jumlah_Transaksi;
    }

    public void setJumlah_Transaksi(int jumlah_Transaksi) {
        Jumlah_Transaksi = jumlah_Transaksi;
    }
}
