package com.yohanhadiwijaya.ajrmobile.models;

import java.util.Date;

public class Customer {
    private String id_customer;
    private String nama_customer;
    private String alamat_customer;
    private String tanggal_lahir_customer;
    private String jenis_kelamin_customer;
    private String email_customer;
    private String password_customer;
    private String no_telp_customer;
    private String ktp_customer;
    private String status_customer;

    public Customer(String id_customer, String nama_customer, String alamat_customer, String tanggal_lahir_customer, String jenis_kelamin_customer, String email_customer, String password_customer, String no_telp_customer, String ktp_customer, String status_customer) {
        this.id_customer = id_customer;
        this.nama_customer = nama_customer;
        this.alamat_customer = alamat_customer;
        this.tanggal_lahir_customer = tanggal_lahir_customer;
        this.jenis_kelamin_customer = jenis_kelamin_customer;
        this.email_customer = email_customer;
        this.password_customer = password_customer;
        this.no_telp_customer = no_telp_customer;
        this.ktp_customer = ktp_customer;
        this.status_customer = status_customer;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getAlamat_customer() {
        return alamat_customer;
    }

    public void setAlamat_customer(String alamat_customer) {
        this.alamat_customer = alamat_customer;
    }

    public String getTanggal_lahir_customer() {
        return tanggal_lahir_customer;
    }

    public void setTanggal_lahir_customer(String tanggal_lahir_customer) {
        this.tanggal_lahir_customer = tanggal_lahir_customer;
    }

    public String getJenis_kelamin_customer() {
        return jenis_kelamin_customer;
    }

    public void setJenis_kelamin_customer(String jenis_kelamin_customer) {
        this.jenis_kelamin_customer = jenis_kelamin_customer;
    }

    public String getEmail_customer() {
        return email_customer;
    }

    public void setEmail_customer(String email_customer) {
        this.email_customer = email_customer;
    }

    public String getPassword_customer() {
        return password_customer;
    }

    public void setPassword_customer(String password_customer) {
        this.password_customer = password_customer;
    }

    public String getNo_telp_customer() {
        return no_telp_customer;
    }

    public void setNo_telp_customer(String no_telp_customer) {
        this.no_telp_customer = no_telp_customer;
    }

    public String getKtp_customer() {
        return ktp_customer;
    }

    public void setKtp_customer(String ktp_customer) {
        this.ktp_customer = ktp_customer;
    }

    public String getStatus_customer() {
        return status_customer;
    }

    public void setStatus_customer(String status_customer) {
        this.status_customer = status_customer;
    }
}
