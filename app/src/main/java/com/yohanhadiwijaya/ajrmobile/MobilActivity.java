package com.yohanhadiwijaya.ajrmobile;

import static com.android.volley.Request.Method.GET;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yohanhadiwijaya.ajrmobile.adapters.MobilAdapter;
import com.yohanhadiwijaya.ajrmobile.api.CustomerApi;
import com.yohanhadiwijaya.ajrmobile.models.MobilResponse;
import com.yohanhadiwijaya.ajrmobile.preferences.CustomerPreference;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MobilActivity extends AppCompatActivity {

    public static final int LAUNCH_ADD_ACTIVITY = 123;
    private SwipeRefreshLayout srMobil;
    private MobilAdapter adapter;
    private SearchView svMobil;
    private LinearLayout layoutLoading;
    private RequestQueue queue;
    CustomerPreference customerPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil);
        customerPref = new CustomerPreference(this);
        // Pendeklarasian request queue
        queue = Volley.newRequestQueue(this);
        layoutLoading = findViewById(R.id.layout_loading);
        srMobil = findViewById(R.id.sr_mobil);
        svMobil = findViewById(R.id.SearchMobil);
        srMobil.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllMobil();
            }
        });
        svMobil.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        RecyclerView rvMobil = findViewById(R.id.rv_mobil);
        adapter = new MobilAdapter(new ArrayList<>(), this);
        rvMobil.setLayoutManager(new LinearLayoutManager(MobilActivity.this,
                LinearLayoutManager.VERTICAL, false));
        rvMobil.setAdapter(adapter);
        getAllMobil();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LAUNCH_ADD_ACTIVITY && resultCode == Activity.RESULT_OK)
            getAllMobil();
    }

    private void getAllMobil() {
        srMobil.setRefreshing(true);
        setLoading(true);
        StringRequest stringRequest = new StringRequest(GET,
                CustomerApi.GET_CARS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                MobilResponse mobilResponse = gson.fromJson(response, MobilResponse.class);
                adapter.setMobilList(mobilResponse.getMobilList());
                adapter.getFilter().filter(svMobil.getQuery());
                Toast.makeText(MobilActivity.this, mobilResponse.getMessage(), Toast.LENGTH_SHORT).show();
                srMobil.setRefreshing(false);
                setLoading(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                srMobil.setRefreshing(false);
                setLoading(false);
                try {
                    String responseBody = new String(error.networkResponse.data,
                            StandardCharsets.UTF_8);
                    JSONObject errors = new JSONObject(responseBody);
                    Toast.makeText(MobilActivity.this,
                            errors.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MobilActivity.this, e.getMessage(),
                            Toast.LENGTH_SHORT).show();
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

    // Fungsi untuk menampilkan layout loading
    private void setLoading(boolean isLoading) {
        if (isLoading) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.VISIBLE);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            layoutLoading.setVisibility(View.GONE);
        }
    }
}