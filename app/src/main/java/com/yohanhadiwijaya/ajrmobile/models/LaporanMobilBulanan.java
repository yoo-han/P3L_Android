package com.yohanhadiwijaya.ajrmobile.models;

public class LaporanMobilBulanan {
    private String Tipe_Mobil;
    private String Nama_Mobil;
    private int Jumlah_Peminjam;
    private float Pendapatan_Mobil;

    public LaporanMobilBulanan(String tipe_Mobil, String nama_Mobil, int jumlah_Peminjam, float pendapatan_Mobil) {
        Tipe_Mobil = tipe_Mobil;
        Nama_Mobil = nama_Mobil;
        Jumlah_Peminjam = jumlah_Peminjam;
        Pendapatan_Mobil = pendapatan_Mobil;
    }

    public String getTipe_Mobil() {
        return Tipe_Mobil;
    }

    public void setTipe_Mobil(String tipe_Mobil) {
        Tipe_Mobil = tipe_Mobil;
    }

    public String getNama_Mobil() {
        return Nama_Mobil;
    }

    public void setNama_Mobil(String nama_Mobil) {
        Nama_Mobil = nama_Mobil;
    }

    public int getJumlah_Peminjam() {
        return Jumlah_Peminjam;
    }

    public void setJumlah_Peminjam(int jumlah_Peminjam) {
        Jumlah_Peminjam = jumlah_Peminjam;
    }

    public float getPendapatan_Mobil() {
        return Pendapatan_Mobil;
    }

    public void setPendapatan_Mobil(float pendapatan_Mobil) {
        Pendapatan_Mobil = pendapatan_Mobil;
    }
}
