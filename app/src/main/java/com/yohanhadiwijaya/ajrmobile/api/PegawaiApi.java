package com.yohanhadiwijaya.ajrmobile.api;

public class PegawaiApi {
    public static final String BASE_URL = "https://ajr.yohanhw.site/api/api/";

    public static final String GET_ALL_URL = BASE_URL + "pegawai";
    public static final String GET_BY_ID_URL = BASE_URL + "pegawai/";
    public static final String ADD_URL = BASE_URL + "pegawai";
    public static final String UPDATE_URL = BASE_URL + "updateProfilePegawai/";
    public static final String DELETE_URL = BASE_URL + "pegawai/";
    public static final String LAPORAN_MOBIL_BULANAN = BASE_URL + "laporanBulananMobil/";
    public static final String LAPORAN_DETAIL_PENDAPATAN_BULANAN = BASE_URL + "laporanBulananDetailPendapatan/";
    public static final String LAPORAN_TRANSAKSI_DRIVER = BASE_URL + "laporanBulananTransaksiDriver/";
    public static final String LAPORAN_PERFORMA_DRIVER = BASE_URL + "laporanBulananPerformaDriver/";
    public static final String LAPORAN_TRANSAKSI_CUSTOMER = BASE_URL + "laporanBulananTransaksiCustomer/";
}
