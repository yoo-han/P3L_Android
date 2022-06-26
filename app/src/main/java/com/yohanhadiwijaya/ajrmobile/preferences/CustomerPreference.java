package com.yohanhadiwijaya.ajrmobile.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.yohanhadiwijaya.ajrmobile.models.Customer;
import com.yohanhadiwijaya.ajrmobile.models.Login;

public class CustomerPreference {
    SharedPreferences sharedPreference;
    SharedPreferences.Editor editor;
    Context con;

    public static final String IS_LOGIN = "IsLogin";
    public static final String KEY_ID_CUSTOMER = "ID_CUSTOMER";
    public static final String KEY_NAMA_CUSTOMER = "NAMA_CUSTOMER";
    public static final String KEY_ALAMAT_CUSTOMER = "ALAMAT_CUSTOMER";
    public static final String KEY_TANGGAL_LAHIR_CUSTOMER = "TANGGALLAHIR_CUSTOMER";
    public static final String KEY_JENIS_KELAMIN_CUSTOMER = "JENISKELAMIN_CUSTOMER";
    public static final String KEY_EMAIL_CUSTOMER = "EMAIL_CUSTOMER";
    public static final String KEY_PASSWORD_CUSTOMER = "PASSWORD_CUSTOMER";
    public static final String KEY_NO_TELP_CUSTOMER = "NOTELP_CUSTOMER";
    public static final String KEY_KTP_CUSTOMER = "KTP_CUSTOMER";
    public static final String KEY_STATUS_CUSTOMER = "STATUS_CUSTOMER";

    public CustomerPreference(Context C)
    {
        con = C;
        sharedPreference = C.getSharedPreferences("customerPreference", Context.MODE_PRIVATE);
        editor = sharedPreference.edit();
    }

    public void SetLogin(Customer customer)
    {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_ID_CUSTOMER, customer.getId_customer());
        editor.putString(KEY_NAMA_CUSTOMER, customer.getNama_customer());
        editor.putString(KEY_ALAMAT_CUSTOMER, customer.getAlamat_customer());
        editor.putString(KEY_TANGGAL_LAHIR_CUSTOMER, customer.getTanggal_lahir_customer());
        editor.putString(KEY_JENIS_KELAMIN_CUSTOMER, customer.getJenis_kelamin_customer());
        editor.putString(KEY_EMAIL_CUSTOMER, customer.getEmail_customer());
        editor.putString(KEY_PASSWORD_CUSTOMER, customer.getPassword_customer());
        editor.putString(KEY_NO_TELP_CUSTOMER, customer.getNo_telp_customer());
        editor.putString(KEY_KTP_CUSTOMER, customer.getKtp_customer());
        editor.putString(KEY_STATUS_CUSTOMER, customer.getStatus_customer());

        editor.commit();
    }

    public Login GetCustomerLogin()
    {
        String email, pass;

        email = sharedPreference.getString(KEY_EMAIL_CUSTOMER, null);
        pass = sharedPreference.getString(KEY_PASSWORD_CUSTOMER, null);
        return new Login(email, pass);
    }

    public Customer GetCustomerNow()
    {
        String id_customer, nama_customer,alamat_customer,tanggal_lahir_customer,jenis_kelamin_customer,email_customer,password_customer,no_telp_customer,ktp_customer,status_customer;
        id_customer = sharedPreference.getString(KEY_ID_CUSTOMER, null);
        nama_customer = sharedPreference.getString(KEY_NAMA_CUSTOMER, null);
        alamat_customer = sharedPreference.getString(KEY_ALAMAT_CUSTOMER, null);
        tanggal_lahir_customer = sharedPreference.getString(KEY_TANGGAL_LAHIR_CUSTOMER, null);
        jenis_kelamin_customer = sharedPreference.getString(KEY_JENIS_KELAMIN_CUSTOMER, null);
        email_customer  = sharedPreference.getString(KEY_EMAIL_CUSTOMER, null);
        password_customer = sharedPreference.getString(KEY_PASSWORD_CUSTOMER, null);
        no_telp_customer = sharedPreference.getString(KEY_NO_TELP_CUSTOMER, null);
        ktp_customer = sharedPreference.getString(KEY_KTP_CUSTOMER, null);
        status_customer = sharedPreference.getString(KEY_STATUS_CUSTOMER, null);

        return new Customer(id_customer, nama_customer, alamat_customer, tanggal_lahir_customer, jenis_kelamin_customer, email_customer, password_customer, no_telp_customer, ktp_customer, status_customer);
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

    public String getCustomerId()
    {
        return sharedPreference.getString(KEY_ID_CUSTOMER, null);
    }


}
