package com.yohanhadiwijaya.ajrmobile.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.yohanhadiwijaya.ajrmobile.models.Driver;
import com.yohanhadiwijaya.ajrmobile.models.Login;

public class DriverPreference {
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "IsLogin";
    public static final String KEY_ID_DRIVER = "ID_DRIVER";
    public static final String KEY_NAMA_DRIVER = "NAMA_DRIVER";
    public static final String KEY_ALAMAT_DRIVER = "ALAMAT_DRIVER";
    public static final String KEY_TANGGAL_LAHIR_DRIVER = "TANGGALLAHIR_DRIVER";
    public static final String KEY_JENIS_KELAMIN_DRIVER = "JENISKELAMIN_DRIVER";
    public static final String KEY_EMAIL_DRIVER = "EMAIL_DRIVER";
    public static final String KEY_PASSWORD_DRIVER = "PASSWORD_DRIVER";
    public static final String KEY_NO_TELP_DRIVER = "NOTELP_DRIVER";
    public static final String KEY_BAHASA = "BAHASA";
    public static final String KEY_FOTO_DRIVER = "FOTO_DRIVER";
    public static final String KEY_SIM_DRIVER = "SIM_DRIVER";
    public static final String KEY_SURAT_BEBAS_NAPZA = "SURAT_BEBAS_NAPZA";
    public static final String KEY_SURAT_KESEHATAN_JASMANI = "SURAT_KESEHATAN_JASMANI";
    public static final String KEY_SURAT_KESEHATAN_JIWA = "SURAT_KESEHATAN_JIWA";
    public static final String KEY_SKCK = "SKCK";
    public static final String KEY_STATUS_DRIVER = "STATUS_DRIVER";
    public static final float KEY_RERATA_RATING = 0;
    public static final int KEY_BANYAK_RATING = 0;

    public DriverPreference(Context C)
    {
        con = C;
        sharedPreference = C.getSharedPreferences("driverPreference", Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
    }

    public void SetLogin(Driver driver)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ID_DRIVER, driver.getId_driver());
        editor.putString(KEY_NAMA_DRIVER, driver.getNama_driver());
        editor.putString(KEY_ALAMAT_DRIVER, driver.getAlamat_driver());
        editor.putString(KEY_TANGGAL_LAHIR_DRIVER, driver.getTanggal_lahir_driver());
        editor.putString(KEY_JENIS_KELAMIN_DRIVER, driver.getJenis_kelamin_driver());
        editor.putString(KEY_EMAIL_DRIVER, driver.getEmail_driver());
        editor.putString(KEY_PASSWORD_DRIVER, driver.getPassword_driver());
        editor.putString(KEY_NO_TELP_DRIVER, driver.getNo_telp_driver());
        editor.putString(KEY_BAHASA, driver.getBahasa());
        editor.putString(KEY_FOTO_DRIVER, driver.getFoto_driver());
        editor.putString(KEY_SIM_DRIVER, driver.getSim_driver());
        editor.putString(KEY_SURAT_BEBAS_NAPZA, driver.getSurat_bebas_napza());
        editor.putString(KEY_SURAT_KESEHATAN_JASMANI, driver.getSurat_kesehatan_jasmani());
        editor.putString(KEY_SURAT_KESEHATAN_JIWA, driver.getSurat_kesehatan_jiwa());
        editor.putString(KEY_SKCK, driver.getSkck());
        editor.putString(KEY_STATUS_DRIVER, driver.getStatus_driver());
        editor.putFloat(String.valueOf(KEY_RERATA_RATING), driver.getRerata_rating());
        editor.putInt(String.valueOf(KEY_BANYAK_RATING), driver.getBanyak_rating());

        editor.commit();
    }

    public Login GetDriverLogin()
    {
        String email, pass;

        email = sharedPreference.getString(KEY_EMAIL_DRIVER, null);
        pass = sharedPreference.getString(KEY_PASSWORD_DRIVER, null);
        return new Login(email, pass);
    }

    public Driver GetDriverNow()
    {
        String id_driver, nama_driver,alamat_driver,tanggal_lahir_driver,
                jenis_kelamin_driver,email_driver,password_driver,no_telp_driver,
                bahasa,foto_driver, sim_driver,surat_bebas_napza,surat_kesehatan_jasmani,
                surat_kesehatan_jiwa,skck,status_driver;
        float rerata_rating;
        int banyak_rating;

        id_driver = sharedPreference.getString(KEY_ID_DRIVER, null);
        nama_driver = sharedPreference.getString(KEY_NAMA_DRIVER, null);
        alamat_driver = sharedPreference.getString(KEY_ALAMAT_DRIVER, null);
        tanggal_lahir_driver = sharedPreference.getString(KEY_TANGGAL_LAHIR_DRIVER, null);
        jenis_kelamin_driver = sharedPreference.getString(KEY_JENIS_KELAMIN_DRIVER, null);
        email_driver  = sharedPreference.getString(KEY_EMAIL_DRIVER, null);
        password_driver = sharedPreference.getString(KEY_PASSWORD_DRIVER, null);
        no_telp_driver = sharedPreference.getString(KEY_NO_TELP_DRIVER, null);
        bahasa = sharedPreference.getString(KEY_BAHASA, null);
        foto_driver = sharedPreference.getString(KEY_FOTO_DRIVER,null);
        sim_driver = sharedPreference.getString(KEY_SIM_DRIVER, null);
        surat_bebas_napza = sharedPreference.getString(KEY_SURAT_BEBAS_NAPZA, null);
        surat_kesehatan_jasmani = sharedPreference.getString(KEY_SURAT_KESEHATAN_JASMANI, null);
        surat_kesehatan_jiwa = sharedPreference.getString(KEY_SURAT_KESEHATAN_JIWA, null);
        skck = sharedPreference.getString(KEY_SKCK, null);
        status_driver = sharedPreference.getString(KEY_STATUS_DRIVER, null);
        rerata_rating = sharedPreference.getFloat(String.valueOf(KEY_RERATA_RATING), 0);
        banyak_rating = sharedPreference.getInt(String.valueOf(KEY_BANYAK_RATING), 0);

        return new Driver(id_driver,nama_driver,alamat_driver,tanggal_lahir_driver,
                jenis_kelamin_driver,email_driver,password_driver,no_telp_driver,
                bahasa,foto_driver,sim_driver,surat_bebas_napza,surat_kesehatan_jasmani,
                surat_kesehatan_jiwa,skck,status_driver,rerata_rating,banyak_rating);
    }

    public boolean CheckLogin()
    {
        return sharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void Logout()
    {
        editor.clear();
        editor.commit();
    }

    public String getDriverId()
    {
        return sharedPreference.getString(KEY_ID_DRIVER, null);
    }
}
