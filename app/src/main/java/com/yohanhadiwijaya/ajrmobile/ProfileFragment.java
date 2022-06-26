package com.yohanhadiwijaya.ajrmobile;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import static com.android.volley.Request.Method.GET;
import static com.android.volley.Request.Method.POST;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.yohanhadiwijaya.ajrmobile.api.CustomerApi;
import com.yohanhadiwijaya.ajrmobile.api.DriverApi;
import com.yohanhadiwijaya.ajrmobile.api.PegawaiApi;
import com.yohanhadiwijaya.ajrmobile.databinding.FragmentProfileBinding;
import com.yohanhadiwijaya.ajrmobile.models.Customer;
import com.yohanhadiwijaya.ajrmobile.models.CustomerResponse;
import com.yohanhadiwijaya.ajrmobile.models.Driver;
import com.yohanhadiwijaya.ajrmobile.models.DriverResponse;
import com.yohanhadiwijaya.ajrmobile.models.Pegawai;
import com.yohanhadiwijaya.ajrmobile.models.PegawaiResponse;
import com.yohanhadiwijaya.ajrmobile.preferences.CustomerPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.DriverPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.PegawaiPreference;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private FragmentProfileBinding binding;
    private CustomerPreference customerPreference;
    private DriverPreference driverPreference;
    private PegawaiPreference pegawaiPreference;

    private Customer customer;
    private Driver driver;
    private Pegawai pegawai;

    private RequestQueue queue;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        queue = Volley.newRequestQueue(getActivity().getApplicationContext());

        customerPreference = new CustomerPreference(this.getActivity().getApplicationContext());
        driverPreference = new DriverPreference(this.getActivity().getApplicationContext());
        pegawaiPreference = new PegawaiPreference(this.getActivity().getApplicationContext());

        if(customerPreference.CheckLogin())
            customer = customerPreference.GetCustomerNow();
        else if(driverPreference.CheckLogin())
            driver = driverPreference.GetDriverNow();
        else if(pegawaiPreference.CheckLogin())
            pegawai = pegawaiPreference.GetPegawaiNow();

        if(customerPreference.CheckLogin()) {
            binding.namaProfil.setText(customer.getNama_customer());
            binding.status.setText(customer.getStatus_customer());
            binding.btnStatusDropdown.setVisibility(GONE);
            binding.etNama.setText(customer.getNama_customer());
            binding.etEmail.setText(customer.getEmail_customer());
            binding.etJenisKelamin.setText(customer.getJenis_kelamin_customer());
            binding.etNoTelp.setText(customer.getNo_telp_customer());
            binding.etTanggalLahir.setText(customer.getTanggal_lahir_customer());
            binding.etAlamat.setText(customer.getAlamat_customer());
            binding.ratingBar.setVisibility(GONE);
            binding.ratingText.setVisibility(GONE);
        }
        else if(driverPreference.CheckLogin()) {
            Glide.with(getActivity().getApplicationContext())
                    .load("http://192.168.1.5:8000/storage/" + driver.getFoto_driver())
                    .placeholder(R.drawable.default_pp)
                    .into(binding.profileImage);
            binding.namaProfil.setText(driver.getNama_driver());
            binding.status.setText(driver.getStatus_driver());
            binding.etNama.setText(driver.getNama_driver());
            binding.etEmail.setText(driver.getEmail_driver());
            binding.etJenisKelamin.setText(driver.getJenis_kelamin_driver());
            binding.etNoTelp.setText(driver.getNo_telp_driver());
            binding.etTanggalLahir.setText(driver.getTanggal_lahir_driver());
            binding.etAlamat.setText(driver.getAlamat_driver());
            binding.ratingBar.setRating(driver.getRerata_rating());
            binding.ratingText.setText(String.valueOf(driver.getRerata_rating()));
        }
        else if(pegawaiPreference.CheckLogin()) {
            Glide.with(getActivity().getApplicationContext())
                    .load("http://192.168.1.5:8000/storage/" + pegawai.getFoto_pegawai())
                    .placeholder(R.drawable.default_pp)
                    .into(binding.profileImage);
            binding.namaProfil.setText(pegawai.getNama_pegawai());
            binding.status.setText(pegawai.getJabatan_pegawai());
            binding.etNama.setText(pegawai.getNama_pegawai());
            binding.btnStatusDropdown.setVisibility(GONE);
            binding.etEmail.setText(pegawai.getEmail_pegawai());
            binding.etJenisKelamin.setText(pegawai.getJenis_kelamin_pegawai());
            binding.etNoTelp.setText(pegawai.getNo_telp_pegawai());
            binding.etTanggalLahir.setText(pegawai.getTanggal_lahir_pegawai());
            binding.etAlamat.setText(pegawai.getAlamat_pegawai());
            binding.ratingBar.setVisibility(GONE);
            binding.ratingText.setVisibility(GONE);
        }

        binding.btnStatusDropdown.setOnClickListener(this);
        binding.btnEditData.setOnClickListener(this);
        binding.btnDoneEditData.setOnClickListener(this);
        binding.btnKeluar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_status_dropdown){
            PopupMenu dropDownMenu = new PopupMenu(getActivity().getApplicationContext(), binding.btnStatusDropdown);
            dropDownMenu.getMenuInflater().inflate(R.menu.status_menu, dropDownMenu.getMenu());
            dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    binding.status.setText(menuItem.getTitle());
                    updateDriver();
                    return true;
                }
            });
            dropDownMenu.show();
        }
        else if(view.getId() == R.id.btn_editData){
            binding.btnEditData.setVisibility(GONE);
            binding.etNama.setEnabled(true);
            binding.etAlamat.setEnabled(true);
            binding.etTanggalLahir.setEnabled(true);
            binding.etNoTelp.setEnabled(true);
            binding.etEmail.setEnabled(true);
            binding.etJenisKelamin.setEnabled(true);
            binding.btnDoneEditData.setVisibility(VISIBLE);
        }
        else if(view.getId() == R.id.btn_doneEditData){
            if(customerPreference.CheckLogin()) {
                updateCustomer();
                binding.btnEditData.setVisibility(VISIBLE);
                binding.etNama.setEnabled(false);
                binding.etAlamat.setEnabled(false);
                binding.etTanggalLahir.setEnabled(false);
                binding.etNoTelp.setEnabled(false);
                binding.etEmail.setEnabled(false);
                binding.etJenisKelamin.setEnabled(false);
                binding.btnDoneEditData.setVisibility(GONE);
            }
            else if(driverPreference.CheckLogin()) {
                updateDriver();
                binding.btnEditData.setVisibility(VISIBLE);
                binding.etNama.setEnabled(false);
                binding.etAlamat.setEnabled(false);
                binding.etTanggalLahir.setEnabled(false);
                binding.etNoTelp.setEnabled(false);
                binding.etEmail.setEnabled(false);
                binding.etJenisKelamin.setEnabled(false);
                binding.btnDoneEditData.setVisibility(GONE);
            }
            else if(pegawaiPreference.CheckLogin()) {
                updatePegawai();
                binding.btnEditData.setVisibility(VISIBLE);
                binding.etNama.setEnabled(false);
                binding.etAlamat.setEnabled(false);
                binding.etTanggalLahir.setEnabled(false);
                binding.etNoTelp.setEnabled(false);
                binding.etEmail.setEnabled(false);
                binding.etJenisKelamin.setEnabled(false);
                binding.btnDoneEditData.setVisibility(GONE);
            }
        }
        else if(view.getId() == R.id.btn_keluar){
            if(customerPreference.CheckLogin()) {
                customerPreference.Logout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if(driverPreference.CheckLogin()) {
                driverPreference.Logout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
            else if(pegawaiPreference.CheckLogin()) {
                pegawaiPreference.Logout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }
    }

    private void updateDriver() {
        setLoading(true);

        driver.setNama_driver(binding.etNama.getText().toString());
        driver.setEmail_driver(binding.etEmail.getText().toString());
        driver.setAlamat_driver(binding.etAlamat.getText().toString());
        driver.setJenis_kelamin_driver(binding.etJenisKelamin.getText().toString());
        driver.setNo_telp_driver(binding.etNoTelp.getText().toString());
        driver.setTanggal_lahir_driver(binding.etTanggalLahir.getText().toString());
        driver.setStatus_driver(binding.status.getText().toString());

        final StringRequest stringRequest = new StringRequest(POST, DriverApi.UPDATE_URL + driverPreference.getDriverId(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        DriverResponse driverResponse = gson.fromJson(response, DriverResponse.class);
                        getDriverById();

                        Toast.makeText(getActivity(), "Update Profile berhasil",
                                Toast.LENGTH_SHORT).show();

                        setLoading(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);

                try {
                    String responseBody =
                            new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(getActivity(), errors.getString("message"),
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(),
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
                String requestBody = gson.toJson(driver);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
        };

        queue.add(stringRequest);
    }

    private void updateCustomer() {
        setLoading(true);

        customer.setNama_customer(binding.etNama.getText().toString());
        customer.setEmail_customer(binding.etEmail.getText().toString());
        customer.setAlamat_customer(binding.etAlamat.getText().toString());
        customer.setJenis_kelamin_customer(binding.etJenisKelamin.getText().toString());
        customer.setNo_telp_customer(binding.etNoTelp.getText().toString());
        customer.setTanggal_lahir_customer(binding.etTanggalLahir.getText().toString());
        customer.setStatus_customer(binding.status.getText().toString());

        final StringRequest stringRequest = new StringRequest(POST, CustomerApi.UPDATE_URL + customerPreference.getCustomerId(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        CustomerResponse customerResponse = gson.fromJson(response, CustomerResponse.class);
                        getCustomerById();

                        Toast.makeText(getActivity(), "Update Profile berhasil",
                                Toast.LENGTH_SHORT).show();

                        setLoading(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);

                try {
                    String responseBody =
                            new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(getActivity(), errors.getString("message"),
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(),
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
                String requestBody = gson.toJson(customer);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
        };

        queue.add(stringRequest);
    }

    private void updatePegawai() {
        setLoading(true);

        pegawai.setNama_pegawai(binding.etNama.getText().toString());
        pegawai.setEmail_pegawai(binding.etEmail.getText().toString());
        pegawai.setAlamat_pegawai(binding.etAlamat.getText().toString());
        pegawai.setJenis_kelamin_pegawai(binding.etJenisKelamin.getText().toString());
        pegawai.setNo_telp_pegawai(binding.etNoTelp.getText().toString());
        pegawai.setTanggal_lahir_pegawai(binding.etTanggalLahir.getText().toString());
        pegawai.setJabatan_pegawai(binding.status.getText().toString());

        final StringRequest stringRequest = new StringRequest(POST, PegawaiApi.UPDATE_URL + String.valueOf(pegawaiPreference.getPegawaiId()),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        PegawaiResponse pegawaiResponse = gson.fromJson(response, PegawaiResponse.class);
                        getPegawaiById();

                        Toast.makeText(getActivity(), "Update Profile berhasil",
                                Toast.LENGTH_SHORT).show();

                        setLoading(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                setLoading(false);

                try {
                    String responseBody =
                            new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);

                    Toast.makeText(getActivity(), errors.getString("message"),
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(),
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
                String requestBody = gson.toJson(pegawai);

                return requestBody.getBytes(StandardCharsets.UTF_8);
            }
        };

        queue.add(stringRequest);
    }

    private void getDriverById() {

        StringRequest stringRequest = new StringRequest(GET, DriverApi.GET_BY_ID_URL+ driverPreference.getDriverId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                DriverResponse driverResponse = gson.fromJson(response, DriverResponse.class);
                Driver driver = driverResponse.getDriver();
                driverPreference.SetLogin(driver);
                binding.namaProfil.setText(driver.getNama_driver());
                binding.status.setText(driver.getStatus_driver());
                binding.etNama.setText(driver.getNama_driver());
                binding.etEmail.setText(driver.getEmail_driver());
                binding.etJenisKelamin.setText(driver.getJenis_kelamin_driver());
                binding.etNoTelp.setText(driver.getNo_telp_driver());
                binding.etTanggalLahir.setText(driver.getTanggal_lahir_driver());
                binding.etAlamat.setText(driver.getAlamat_driver());
                binding.ratingBar.setRating(driver.getRerata_rating());
                binding.ratingText.setText(String.valueOf(driver.getRerata_rating()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(getActivity(), errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        // Menambahkan request ke request queue
        queue.add(stringRequest);

    }

    private void getPegawaiById() {

        StringRequest stringRequest = new StringRequest(GET, PegawaiApi.GET_BY_ID_URL+ pegawaiPreference.getPegawaiId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                PegawaiResponse pegawaiResponse = gson.fromJson(response, PegawaiResponse.class);
                Pegawai pegawai = pegawaiResponse.getPegawai();
                pegawaiPreference.SetLogin(pegawai);
                binding.namaProfil.setText(pegawai.getNama_pegawai());
                binding.status.setText(pegawai.getJabatan_pegawai());
                binding.etNama.setText(pegawai.getNama_pegawai());
                binding.btnStatusDropdown.setVisibility(GONE);
                binding.etEmail.setText(pegawai.getEmail_pegawai());
                binding.etJenisKelamin.setText(pegawai.getJenis_kelamin_pegawai());
                binding.etNoTelp.setText(pegawai.getNo_telp_pegawai());
                binding.etTanggalLahir.setText(pegawai.getTanggal_lahir_pegawai());
                binding.etAlamat.setText(pegawai.getAlamat_pegawai());
                binding.ratingBar.setVisibility(GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(getActivity(), errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        // Menambahkan request ke request queue
        queue.add(stringRequest);

    }

    private void getCustomerById() {

        StringRequest stringRequest = new StringRequest(GET, CustomerApi.GET_BY_ID_URL+ customerPreference.getCustomerId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                CustomerResponse customerResponse = gson.fromJson(response, CustomerResponse.class);
                Customer customer = customerResponse.getCustomer();
                customerPreference.SetLogin(customer);
                binding.namaProfil.setText(customer.getNama_customer());
                binding.status.setText(customer.getStatus_customer());
                binding.btnStatusDropdown.setVisibility(GONE);
                binding.etNama.setText(customer.getNama_customer());
                binding.etEmail.setText(customer.getEmail_customer());
                binding.etJenisKelamin.setText(customer.getJenis_kelamin_customer());
                binding.etNoTelp.setText(customer.getNo_telp_customer());
                binding.etTanggalLahir.setText(customer.getTanggal_lahir_customer());
                binding.etAlamat.setText(customer.getAlamat_customer());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    String responseBody = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(getActivity(), errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            // Menambahkan header pada request
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        // Menambahkan request ke request queue
        queue.add(stringRequest);

    }

    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            binding.layoutLoading.setVisibility(VISIBLE);
        } else {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            binding.layoutLoading.setVisibility(GONE);
        }
    }
}