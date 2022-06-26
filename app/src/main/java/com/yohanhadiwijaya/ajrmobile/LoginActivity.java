package com.yohanhadiwijaya.ajrmobile;

import static com.android.volley.Request.Method.POST;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yohanhadiwijaya.ajrmobile.api.LoginApi;
import com.yohanhadiwijaya.ajrmobile.databinding.ActivityLoginBinding;
import com.yohanhadiwijaya.ajrmobile.models.Customer;
import com.yohanhadiwijaya.ajrmobile.models.CustomerResponse;
import com.yohanhadiwijaya.ajrmobile.models.Driver;
import com.yohanhadiwijaya.ajrmobile.models.DriverResponse;
import com.yohanhadiwijaya.ajrmobile.models.Login;
import com.yohanhadiwijaya.ajrmobile.models.Pegawai;
import com.yohanhadiwijaya.ajrmobile.models.PegawaiResponse;
import com.yohanhadiwijaya.ajrmobile.preferences.CustomerPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.DriverPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.PegawaiPreference;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityLoginBinding binding;
    private Login loginData;
    private CustomerPreference customerPreference;
    private DriverPreference driverPreference;
    private PegawaiPreference pegawaiPreference;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        queue = Volley.newRequestQueue(this.getApplicationContext());

        loginData = new Login("","");
        binding.setLogin(loginData);
        binding.btnMasuk.setOnClickListener(this);

        customerPreference = new CustomerPreference(this);
        driverPreference = new DriverPreference(this);
        pegawaiPreference = new PegawaiPreference(this);

        CheckLogin();
    }

    @Override
    public void onClick(View view) {
        if(CekKosong())
        {
            String email = loginData.getEmail();
            String pass = loginData.getPassword();

            Login(new Login(email, pass));
        }
        else
        {
            Toast.makeText(this, "Silahkan isi semua field", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean CekKosong()
    {
        if(binding.inputLayoutUsername.getEditText().getText().toString().isEmpty())
        {
            return false;
        }else if(binding.inputLayoutPassword.getEditText().getText().toString().isEmpty())
        {
            return false;
        }
        return true;
    }

    private void CheckLogin()
    {
        if(customerPreference.CheckLogin() || driverPreference.CheckLogin() || pegawaiPreference.CheckLogin()){
            Intent move = new Intent(this, ContainerActivity.class);
            startActivity(move);
            finish();
        }

    }

    private void Login(Login login) {
        setLoading(true);

        final StringRequest stringRequest = new StringRequest(POST, LoginApi.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        DriverResponse driverResponse =
                                gson.fromJson(response, DriverResponse.class);
                        CustomerResponse customerResponse =
                                gson.fromJson(response, CustomerResponse.class);
                        PegawaiResponse pegawaiResponse =
                                gson.fromJson(response, PegawaiResponse.class);

                        Driver driver = driverResponse.getDriver();
                        Customer customer = customerResponse.getCustomer();
                        Pegawai pegawai = pegawaiResponse.getPegawai();

                        setLoading(false);
                        if(driver.getId_driver() != null)
                        {
//                            Toast.makeText(LoginActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            Driver driverPref = new Driver(driver.getId_driver(), driver.getNama_driver(), driver.getAlamat_driver(), driver.getTanggal_lahir_driver(),
                                    driver.getJenis_kelamin_driver(), driver.getEmail_driver(), driver.getPassword_driver(), driver.getNo_telp_driver(),
                                    driver.getBahasa(), driver.getFoto_driver(), driver.getSim_driver(), driver.getSurat_bebas_napza(), driver.getSurat_kesehatan_jasmani(),
                                    driver.getSurat_kesehatan_jiwa(), driver.getSkck(), driver.getStatus_driver(), driver.getRerata_rating(), driver.getBanyak_rating());

                            LoginActivity.this.driverPreference.SetLogin(driverPref);
                            CheckLogin();
                        }else if(pegawai.getId_pegawai() != 0 && pegawai.getJabatan_pegawai().equals("Manager")){
//                            Toast.makeText(LoginActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            Pegawai pegawaiPref = new Pegawai(pegawai.getId_pegawai(), pegawai.getNama_pegawai(), pegawai.getAlamat_pegawai(), pegawai.getTanggal_lahir_pegawai(),
                                    pegawai.getJenis_kelamin_pegawai(), pegawai.getEmail_pegawai(), pegawai.getPassword_pegawai(), pegawai.getNo_telp_pegawai(), pegawai.getFoto_pegawai(), pegawai.getJabatan_pegawai());

                            LoginActivity.this.pegawaiPreference.SetLogin(pegawaiPref);
                            CheckLogin();
                        }else if(customer.getId_customer() != null){
//                            Toast.makeText(LoginActivity.this, driverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            Intent returnIntent = new Intent();
                            setResult(Activity.RESULT_OK, returnIntent);

                            Customer customerPref = new Customer(customer.getId_customer(), customer.getNama_customer(), customer.getAlamat_customer(), customer.getTanggal_lahir_customer(),
                                    customer.getJenis_kelamin_customer(), customer.getEmail_customer(), customer.getPassword_customer(), customer.getNo_telp_customer(), customer.getKtp_customer(), customer.getStatus_customer());

                            LoginActivity.this.customerPreference.SetLogin(customerPref);
                            CheckLogin();

                        }else{
                            Toast.makeText(LoginActivity.this, "Login Gagal. Masukkan Email/Password dengan benar!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);

                try {
                    String responseBody =
                            new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(LoginActivity.this, errors.getString("message"),
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");

                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                Gson gson = new Gson();
                String requestBody = gson.toJson(login);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
        };

        queue.add(stringRequest);
    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//            binding.layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//            binding.layoutLoading.setVisibility(View.GONE);
        }
    }
}