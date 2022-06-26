package com.yohanhadiwijaya.ajrmobile.models;

import java.util.Date;

public class Pegawai {
    private int id_pegawai;
    private String nama_pegawai;
    private String alamat_pegawai;
    private String tanggal_lahir_pegawai;
    private String jenis_kelamin_pegawai;
    private String email_pegawai;
    private String password_pegawai;
    private String no_telp_pegawai;
    private String foto_pegawai;
    private String jabatan_pegawai;

    public Pegawai(int id_pegawai, String nama_pegawai, String alamat_pegawai, String tanggal_lahir_pegawai, String jenis_kelamin_pegawai, String email_pegawai, String password_pegawai, String no_telp_pegawai, String foto_pegawai, String jabatan_pegawai) {
        this.id_pegawai = id_pegawai;
        this.nama_pegawai = nama_pegawai;
        this.alamat_pegawai = alamat_pegawai;
        this.tanggal_lahir_pegawai = tanggal_lahir_pegawai;
        this.jenis_kelamin_pegawai = jenis_kelamin_pegawai;
        this.email_pegawai = email_pegawai;
        this.password_pegawai = password_pegawai;
        this.no_telp_pegawai = no_telp_pegawai;
        this.foto_pegawai = foto_pegawai;
        this.jabatan_pegawai = jabatan_pegawai;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public void setNama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getAlamat_pegawai() {
        return alamat_pegawai;
    }

    public void setAlamat_pegawai(String alamat_pegawai) {
        this.alamat_pegawai = alamat_pegawai;
    }

    public String getTanggal_lahir_pegawai() {
        return tanggal_lahir_pegawai;
    }

    public void setTanggal_lahir_pegawai(String tanggal_lahir_pegawai) {
        this.tanggal_lahir_pegawai = tanggal_lahir_pegawai;
    }

    public String getJenis_kelamin_pegawai() {
        return jenis_kelamin_pegawai;
    }

    public void setJenis_kelamin_pegawai(String jenis_kelamin_pegawai) {
        this.jenis_kelamin_pegawai = jenis_kelamin_pegawai;
    }

    public String getEmail_pegawai() {
        return email_pegawai;
    }

    public void setEmail_pegawai(String email_pegawai) {
        this.email_pegawai = email_pegawai;
    }

    public String getPassword_pegawai() {
        return password_pegawai;
    }

    public void setPassword_pegawai(String password_pegawai) {
        this.password_pegawai = password_pegawai;
    }

    public String getNo_telp_pegawai() {
        return no_telp_pegawai;
    }

    public void setNo_telp_pegawai(String no_telp_pegawai) {
        this.no_telp_pegawai = no_telp_pegawai;
    }

    public String getFoto_pegawai() {
        return foto_pegawai;
    }

    public void setFoto_pegawai(String foto_pegawai) {
        this.foto_pegawai = foto_pegawai;
    }

    public String getJabatan_pegawai() {
        return jabatan_pegawai;
    }

    public void setJabatan_pegawai(String jabatan_pegawai) {
        this.jabatan_pegawai = jabatan_pegawai;
    }
}
