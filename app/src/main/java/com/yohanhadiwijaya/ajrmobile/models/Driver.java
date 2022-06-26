package com.yohanhadiwijaya.ajrmobile.models;

import java.util.Date;

public class Driver {
    private String id_driver;
    private String nama_driver;
    private String alamat_driver;
    private String tanggal_lahir_driver;
    private String jenis_kelamin_driver;
    private String email_driver;
    private String password_driver;
    private String no_telp_driver;
    private String bahasa;
    private String foto_driver;
    private String sim_driver;
    private String surat_bebas_napza;
    private String surat_kesehatan_jasmani;
    private String surat_kesehatan_jiwa;
    private String skck;
    private String status_driver;
    private float rerata_rating;
    private int banyak_rating;

    public Driver(String id_driver, String nama_driver, String alamat_driver, String tanggal_lahir_driver, String jenis_kelamin_driver, String email_driver, String password_driver, String no_telp_driver, String bahasa, String foto_driver, String sim_driver, String surat_bebas_napza, String surat_kesehatan_jasmani, String surat_kesehatan_jiwa, String skck, String status_driver, float rerata_rating, int banyak_rating) {
        this.id_driver = id_driver;
        this.nama_driver = nama_driver;
        this.alamat_driver = alamat_driver;
        this.tanggal_lahir_driver = tanggal_lahir_driver;
        this.jenis_kelamin_driver = jenis_kelamin_driver;
        this.email_driver = email_driver;
        this.password_driver = password_driver;
        this.no_telp_driver = no_telp_driver;
        this.bahasa = bahasa;
        this.foto_driver = foto_driver;
        this.sim_driver = sim_driver;
        this.surat_bebas_napza = surat_bebas_napza;
        this.surat_kesehatan_jasmani = surat_kesehatan_jasmani;
        this.surat_kesehatan_jiwa = surat_kesehatan_jiwa;
        this.skck = skck;
        this.status_driver = status_driver;
        this.rerata_rating = rerata_rating;
        this.banyak_rating = banyak_rating;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public String getNama_driver() {
        return nama_driver;
    }

    public void setNama_driver(String nama_driver) {
        this.nama_driver = nama_driver;
    }

    public String getAlamat_driver() {
        return alamat_driver;
    }

    public void setAlamat_driver(String alamat_driver) {
        this.alamat_driver = alamat_driver;
    }

    public String getTanggal_lahir_driver() {
        return tanggal_lahir_driver;
    }

    public void setTanggal_lahir_driver(String tanggal_lahir_driver) {
        this.tanggal_lahir_driver = tanggal_lahir_driver;
    }

    public String getJenis_kelamin_driver() {
        return jenis_kelamin_driver;
    }

    public void setJenis_kelamin_driver(String jenis_kelamin_driver) {
        this.jenis_kelamin_driver = jenis_kelamin_driver;
    }

    public String getEmail_driver() {
        return email_driver;
    }

    public void setEmail_driver(String email_driver) {
        this.email_driver = email_driver;
    }

    public String getPassword_driver() {
        return password_driver;
    }

    public void setPassword_driver(String password_driver) {
        this.password_driver = password_driver;
    }

    public String getNo_telp_driver() {
        return no_telp_driver;
    }

    public void setNo_telp_driver(String no_telp_driver) {
        this.no_telp_driver = no_telp_driver;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getFoto_driver() {
        return foto_driver;
    }

    public void setFoto_driver(String foto_driver) {
        this.foto_driver = foto_driver;
    }

    public String getSim_driver() {
        return sim_driver;
    }

    public void setSim_driver(String sim_driver) {
        this.sim_driver = sim_driver;
    }

    public String getSurat_bebas_napza() {
        return surat_bebas_napza;
    }

    public void setSurat_bebas_napza(String surat_bebas_napza) {
        this.surat_bebas_napza = surat_bebas_napza;
    }

    public String getSurat_kesehatan_jasmani() {
        return surat_kesehatan_jasmani;
    }

    public void setSurat_kesehatan_jasmani(String surat_kesehatan_jasmani) {
        this.surat_kesehatan_jasmani = surat_kesehatan_jasmani;
    }

    public String getSurat_kesehatan_jiwa() {
        return surat_kesehatan_jiwa;
    }

    public void setSurat_kesehatan_jiwa(String surat_kesehatan_jiwa) {
        this.surat_kesehatan_jiwa = surat_kesehatan_jiwa;
    }

    public String getSkck() {
        return skck;
    }

    public void setSkck(String skck) {
        this.skck = skck;
    }

    public String getStatus_driver() {
        return status_driver;
    }

    public void setStatus_driver(String status_driver) {
        this.status_driver = status_driver;
    }

    public float getRerata_rating() {
        return rerata_rating;
    }

    public void setRerata_rating(float rerata_rating) {
        this.rerata_rating = rerata_rating;
    }

    public int getBanyak_rating() {
        return banyak_rating;
    }

    public void setBanyak_rating(int banyak_rating) {
        this.banyak_rating = banyak_rating;
    }
}
