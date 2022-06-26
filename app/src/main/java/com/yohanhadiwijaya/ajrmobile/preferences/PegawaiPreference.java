package com.yohanhadiwijaya.ajrmobile.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.yohanhadiwijaya.ajrmobile.models.Login;
import com.yohanhadiwijaya.ajrmobile.models.Pegawai;

public class PegawaiPreference {
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "IsLogin";
    public static final int KEY_ID_PEGAWAI = 0;
    public static final String KEY_NAMA_PEGAWAI = "NAMA_PEGAWAI";
    public static final String KEY_ALAMAT_PEGAWAI = "ALAMAT_DRIVER";
    public static final String KEY_TANGGAL_LAHIR_PEGAWAI = "TANGGALLAHIR_DRIVER";
    public static final String KEY_JENIS_KELAMIN_PEGAWAI = "JENISKELAMIN_DRIVER";
    public static final String KEY_EMAIL_PEGAWAI = "EMAIL_DRIVER";
    public static final String KEY_PASSWORD_PEGAWAI = "PASSWORD_DRIVER";
    public static final String KEY_NO_TELP_PEGAWAI = "NOTELP_DRIVER";
    public static final String KEY_FOTO_PEGAWAI = "FOTO_PEGAWAI";
    public static final String KEY_JABATAN = "JABATAN";

    public PegawaiPreference(Context C)
    {
        con = C;
        sharedPreference = C.getSharedPreferences("pegawaiPreference", Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
    }

    public void SetLogin(Pegawai pegawai)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putInt(String.valueOf(KEY_ID_PEGAWAI), pegawai.getId_pegawai());
        editor.putString(KEY_NAMA_PEGAWAI, pegawai.getNama_pegawai());
        editor.putString(KEY_ALAMAT_PEGAWAI, pegawai.getAlamat_pegawai());
        editor.putString(KEY_TANGGAL_LAHIR_PEGAWAI, pegawai.getTanggal_lahir_pegawai());
        editor.putString(KEY_JENIS_KELAMIN_PEGAWAI, pegawai.getJenis_kelamin_pegawai());
        editor.putString(KEY_EMAIL_PEGAWAI, pegawai.getEmail_pegawai());
        editor.putString(KEY_PASSWORD_PEGAWAI, pegawai.getPassword_pegawai());
        editor.putString(KEY_NO_TELP_PEGAWAI, pegawai.getNo_telp_pegawai());
        editor.putString(KEY_FOTO_PEGAWAI, pegawai.getFoto_pegawai());
        editor.putString(KEY_JABATAN, pegawai.getJabatan_pegawai());

        editor.commit();
    }

    public Login GetPegawaiLogin()
    {
        String email, pass;

        email = sharedPreference.getString(KEY_EMAIL_PEGAWAI, null);
        pass = sharedPreference.getString(KEY_PASSWORD_PEGAWAI, null);
        return new Login(email, pass);
    }

    public Pegawai GetPegawaiNow()
    {
        int id_pegawai;
        String nama_pegawai,alamat_pegawai,tanggal_lahir_pegawai,jenis_kelamin_pegawai,email_pegawai,password_pegawai,no_telp_pegawai,foto_pegawai,jabatan_pegawai;
        id_pegawai = sharedPreference.getInt(String.valueOf(KEY_ID_PEGAWAI), 0);
        nama_pegawai = sharedPreference.getString(KEY_NAMA_PEGAWAI, null);
        alamat_pegawai = sharedPreference.getString(KEY_ALAMAT_PEGAWAI, null);
        tanggal_lahir_pegawai = sharedPreference.getString(KEY_TANGGAL_LAHIR_PEGAWAI, null);
        jenis_kelamin_pegawai = sharedPreference.getString(KEY_JENIS_KELAMIN_PEGAWAI, null);
        email_pegawai  = sharedPreference.getString(KEY_EMAIL_PEGAWAI, null);
        password_pegawai = sharedPreference.getString(KEY_PASSWORD_PEGAWAI, null);
        no_telp_pegawai = sharedPreference.getString(KEY_NO_TELP_PEGAWAI, null);
        foto_pegawai = sharedPreference.getString(KEY_FOTO_PEGAWAI, null);
        jabatan_pegawai = sharedPreference.getString(KEY_JABATAN, null);

        return new Pegawai(id_pegawai,nama_pegawai,alamat_pegawai,
                tanggal_lahir_pegawai,jenis_kelamin_pegawai,email_pegawai,
                password_pegawai,no_telp_pegawai,foto_pegawai,jabatan_pegawai);
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

    public int getPegawaiId()
    {
        return sharedPreference.getInt(String.valueOf(KEY_ID_PEGAWAI), 0);
    }
}
