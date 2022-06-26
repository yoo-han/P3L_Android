package com.yohanhadiwijaya.ajrmobile.models;

public class Transaction {
    private String id_reservasi;
    private String id_mobil;
    private String id_pegawai;
    private String id_promo;
    private String id_driver;
    private String tanggal_transaksi;
    private String tanggal_mulai;
    private String tanggal_selesai;
    private String jenis_reservasi;
    private String no_sim;
    private float tarif_driver;
    private String metode_pembayaran;
    private String bukti_transfer;
    private float total_pembayaran;
    private String tanggal_kembali;
    private float denda;
    private String rating_driver;
    private String status_reservasi;
    private Mobil get_mobil = null;
    private Driver get_driver = null;
    private Pegawai get_pegawai = null;
    private Promo get_promo = null;

    public Transaction(String id_reservasi, String id_mobil, String id_pegawai, String id_promo, String id_driver, String tanggal_transaksi, String tanggal_mulai, String tanggal_selesai, String jenis_reservasi, String no_sim, float tarif_driver, String metode_pembayaran, String bukti_transfer, float total_pembayaran, String tanggal_kembali, float denda, String rating_driver, String status_reservasi, Mobil get_mobil, Driver get_driver, Pegawai get_pegawai, Promo get_promo) {
        this.id_reservasi = id_reservasi;
        this.id_mobil = id_mobil;
        this.id_pegawai = id_pegawai;
        this.id_promo = id_promo;
        this.id_driver = id_driver;
        this.tanggal_transaksi = tanggal_transaksi;
        this.tanggal_mulai = tanggal_mulai;
        this.tanggal_selesai = tanggal_selesai;
        this.jenis_reservasi = jenis_reservasi;
        this.no_sim = no_sim;
        this.tarif_driver = tarif_driver;
        this.metode_pembayaran = metode_pembayaran;
        this.bukti_transfer = bukti_transfer;
        this.total_pembayaran = total_pembayaran;
        this.tanggal_kembali = tanggal_kembali;
        this.denda = denda;
        this.rating_driver = rating_driver;
        this.status_reservasi = status_reservasi;
        this.get_mobil = get_mobil;
        this.get_driver = get_driver;
        this.get_pegawai = get_pegawai;
        this.get_promo = get_promo;
    }

    public String getId_reservasi() {
        return id_reservasi;
    }

    public void setId_reservasi(String id_reservasi) {
        this.id_reservasi = id_reservasi;
    }

    public String getId_mobil() {
        return id_mobil;
    }

    public void setId_mobil(String id_mobil) {
        this.id_mobil = id_mobil;
    }

    public String getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(String id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getId_promo() {
        return id_promo;
    }

    public void setId_promo(String id_promo) {
        this.id_promo = id_promo;
    }

    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(String id_driver) {
        this.id_driver = id_driver;
    }

    public String getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(String tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }

    public String getJenis_reservasi() {
        return jenis_reservasi;
    }

    public void setJenis_reservasi(String jenis_reservasi) {
        this.jenis_reservasi = jenis_reservasi;
    }

    public String getNo_sim() {
        return no_sim;
    }

    public void setNo_sim(String no_sim) {
        this.no_sim = no_sim;
    }

    public float getTarif_driver() {
        return tarif_driver;
    }

    public void setTarif_driver(float tarif_driver) {
        this.tarif_driver = tarif_driver;
    }

    public String getMetode_pembayaran() {
        return metode_pembayaran;
    }

    public void setMetode_pembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public String getBukti_transfer() {
        return bukti_transfer;
    }

    public void setBukti_transfer(String bukti_transfer) {
        this.bukti_transfer = bukti_transfer;
    }

    public float getTotal_pembayaran() {
        return total_pembayaran;
    }

    public void setTotal_pembayaran(float total_pembayaran) {
        this.total_pembayaran = total_pembayaran;
    }

    public String getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(String tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public float getDenda() {
        return denda;
    }

    public void setDenda(float denda) {
        this.denda = denda;
    }

    public String getRating_driver() {
        return rating_driver;
    }

    public void setRating_driver(String rating_driver) {
        this.rating_driver = rating_driver;
    }

    public String getStatus_reservasi() {
        return status_reservasi;
    }

    public void setStatus_reservasi(String status_reservasi) {
        this.status_reservasi = status_reservasi;
    }

    public Mobil getGet_mobil() {
        return get_mobil;
    }

    public void setGet_mobil(Mobil get_mobil) {
        this.get_mobil = get_mobil;
    }

    public Driver getGet_driver() {
        return get_driver;
    }

    public void setGet_driver(Driver get_driver) {
        this.get_driver = get_driver;
    }

    public Pegawai getGet_pegawai() {
        return get_pegawai;
    }

    public void setGet_pegawai(Pegawai get_pegawai) {
        this.get_pegawai = get_pegawai;
    }

    public Promo getGet_promo() {
        return get_promo;
    }

    public void setGet_promo(Promo get_promo) {
        this.get_promo = get_promo;
    }
}
