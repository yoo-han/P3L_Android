package com.yohanhadiwijaya.ajrmobile.models;

public class Mobil {
    private int id_mobil;
    private int id_mitra;
    private String nama_mobil;
    private String tipe_mobil;
    private String jenis_transmisi;
    private String jenis_bahan_bakar;
    private float volume_bahan_bakar;
    private String warna_mobil;
    private int kapasitas_penumpang;
    private String fasilitas;
    private String kategori_aset;
    private String plat_nomor;
    private String nomor_stnk;
    private float harga_sewa;
    private String foto_mobil;
    private int total_peminjaman;
    private String tanggal_terakhir_servis;

    public Mobil(int id_mobil, int id_mitra, String nama_mobil, String tipe_mobil, String jenis_transmisi, String jenis_bahan_bakar, float volume_bahan_bakar, String warna_mobil, int kapasitas_penumpang, String fasilitas, String kategori_aset, String plat_nomor, String nomor_stnk, float harga_sewa, String foto_mobil, int total_peminjaman, String tanggal_terakhir_servis) {
        this.id_mobil = id_mobil;
        this.id_mitra = id_mitra;
        this.nama_mobil = nama_mobil;
        this.tipe_mobil = tipe_mobil;
        this.jenis_transmisi = jenis_transmisi;
        this.jenis_bahan_bakar = jenis_bahan_bakar;
        this.volume_bahan_bakar = volume_bahan_bakar;
        this.warna_mobil = warna_mobil;
        this.kapasitas_penumpang = kapasitas_penumpang;
        this.fasilitas = fasilitas;
        this.kategori_aset = kategori_aset;
        this.plat_nomor = plat_nomor;
        this.nomor_stnk = nomor_stnk;
        this.harga_sewa = harga_sewa;
        this.foto_mobil = foto_mobil;
        this.total_peminjaman = total_peminjaman;
        this.tanggal_terakhir_servis = tanggal_terakhir_servis;
    }

    public int getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(int id_mobil) {
        this.id_mobil = id_mobil;
    }

    public int getId_mitra() {
        return id_mitra;
    }

    public void setId_mitra(int id_mitra) {
        this.id_mitra = id_mitra;
    }

    public String getNama_mobil() {
        return nama_mobil;
    }

    public void setNama_mobil(String nama_mobil) {
        this.nama_mobil = nama_mobil;
    }

    public String getTipe_mobil() {
        return tipe_mobil;
    }

    public void setTipe_mobil(String tipe_mobil) {
        this.tipe_mobil = tipe_mobil;
    }

    public String getJenis_transmisi() {
        return jenis_transmisi;
    }

    public void setJenis_transmisi(String jenis_transmisi) {
        this.jenis_transmisi = jenis_transmisi;
    }

    public String getJenis_bahan_bakar() {
        return jenis_bahan_bakar;
    }

    public void setJenis_bahan_bakar(String jenis_bahan_bakar) {
        this.jenis_bahan_bakar = jenis_bahan_bakar;
    }

    public float getVolume_bahan_bakar() {
        return volume_bahan_bakar;
    }

    public void setVolume_bahan_bakar(float volume_bahan_bakar) {
        this.volume_bahan_bakar = volume_bahan_bakar;
    }

    public String getWarna_mobil() {
        return warna_mobil;
    }

    public void setWarna_mobil(String warna_mobil) {
        this.warna_mobil = warna_mobil;
    }

    public int getKapasitas_penumpang() {
        return kapasitas_penumpang;
    }

    public void setKapasitas_penumpang(int kapasitas_penumpang) {
        this.kapasitas_penumpang = kapasitas_penumpang;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getKategori_aset() {
        return kategori_aset;
    }

    public void setKategori_aset(String kategori_aset) {
        this.kategori_aset = kategori_aset;
    }

    public String getPlat_nomor() {
        return plat_nomor;
    }

    public void setPlat_nomor(String plat_nomor) {
        this.plat_nomor = plat_nomor;
    }

    public String getNomor_stnk() {
        return nomor_stnk;
    }

    public void setNomor_stnk(String nomor_stnk) {
        this.nomor_stnk = nomor_stnk;
    }

    public float getHarga_sewa() {
        return harga_sewa;
    }

    public void setHarga_sewa(float harga_sewa) {
        this.harga_sewa = harga_sewa;
    }

    public String getFoto_mobil() {
        return foto_mobil;
    }

    public void setFoto_mobil(String foto_mobil) {
        this.foto_mobil = foto_mobil;
    }

    public int getTotal_peminjaman() {
        return total_peminjaman;
    }

    public void setTotal_peminjaman(int total_peminjaman) {
        this.total_peminjaman = total_peminjaman;
    }

    public String getTanggal_terakhir_servis() {
        return tanggal_terakhir_servis;
    }

    public void setTanggal_terakhir_servis(String tanggal_terakhir_servis) {
        this.tanggal_terakhir_servis = tanggal_terakhir_servis;
    }
}
