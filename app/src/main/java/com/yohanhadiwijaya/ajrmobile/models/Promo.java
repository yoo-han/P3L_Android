package com.yohanhadiwijaya.ajrmobile.models;

public class Promo {
    private int id_promo;
    private String kode_promo;
    private String jenis_promo;
    private float potongan_promo;
    private String keterangan_promo;
    private String status_promo;

    public Promo(int id_promo, String kode_promo, String jenis_promo, float potongan_promo, String keterangan_promo, String status_promo) {
        this.id_promo = id_promo;
        this.kode_promo = kode_promo;
        this.jenis_promo = jenis_promo;
        this.potongan_promo = potongan_promo;
        this.keterangan_promo = keterangan_promo;
        this.status_promo = status_promo;
    }

    public int getId_promo() {
        return id_promo;
    }

    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }

    public String getKode_promo() {
        return kode_promo;
    }

    public void setKode_promo(String kode_promo) {
        this.kode_promo = kode_promo;
    }

    public String getJenis_promo() {
        return jenis_promo;
    }

    public void setJenis_promo(String jenis_promo) {
        this.jenis_promo = jenis_promo;
    }

    public float getPotongan_promo() {
        return potongan_promo;
    }

    public void setPotongan_promo(float potongan_promo) {
        this.potongan_promo = potongan_promo;
    }

    public String getKeterangan_promo() {
        return keterangan_promo;
    }

    public void setKeterangan_promo(String keterangan_promo) {
        this.keterangan_promo = keterangan_promo;
    }

    public String getStatus_promo() {
        return status_promo;
    }

    public void setStatus_promo(String status_promo) {
        this.status_promo = status_promo;
    }
}
