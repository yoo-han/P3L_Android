package com.yohanhadiwijaya.ajrmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yohanhadiwijaya.ajrmobile.databinding.ActivityContainerBinding;
import com.yohanhadiwijaya.ajrmobile.preferences.CustomerPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.DriverPreference;
import com.yohanhadiwijaya.ajrmobile.preferences.PegawaiPreference;

public class ContainerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private ActivityContainerBinding binding;
    private CustomerPreference customerPreference;
    private DriverPreference driverPreference;
    private PegawaiPreference pegawaiPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_container);
        binding.bottomNavigation.setOnItemSelectedListener(this);

        customerPreference = new CustomerPreference(this);
        driverPreference = new DriverPreference(this);
        pegawaiPreference = new PegawaiPreference(this);

        if(customerPreference.CheckLogin())
            changeFragment(new CustomerDashboardFragment());
        else if(driverPreference.CheckLogin())
            changeFragment(new DriverDashboardFragment());
        else if(pegawaiPreference.CheckLogin())
            changeFragment(new PegawaiDashboardFragment());

        CheckLogin();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_beranda){
            if(customerPreference.CheckLogin())
                changeFragment(new CustomerDashboardFragment());
            else if(driverPreference.CheckLogin())
                changeFragment(new DriverDashboardFragment());
            else if(pegawaiPreference.CheckLogin())
                changeFragment(new PegawaiDashboardFragment());
        }else if(item.getItemId() == R.id.menu_profil){
            changeFragment(new ProfileFragment());
        }

        return true;
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.layout_fragment, fragment)
                .commit();
    }

    private void CheckLogin()
    {
        if(!customerPreference.CheckLogin() && !driverPreference.CheckLogin() && !pegawaiPreference.CheckLogin())
        {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        else
        {
            Toast.makeText(this, "Welcome to Atma Jogja Rental", Toast.LENGTH_SHORT).show();
        }
    }
}