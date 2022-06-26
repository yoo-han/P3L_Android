package com.yohanhadiwijaya.ajrmobile;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yohanhadiwijaya.ajrmobile.databinding.FragmentDriverDashboardBinding;
import com.yohanhadiwijaya.ajrmobile.models.Driver;
import com.yohanhadiwijaya.ajrmobile.preferences.DriverPreference;

public class DriverDashboardFragment extends Fragment implements View.OnClickListener {

    private FragmentDriverDashboardBinding binding;
    private DriverPreference driverPreference;
    private Driver driver;
    private BottomNavigationView nav;

    public DriverDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_driver_dashboard, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        driverPreference = new DriverPreference(this.getActivity().getApplicationContext());
        driver = driverPreference.GetDriverNow();

        binding.btnTransaksiDriver.setOnClickListener(this);
        nav = getActivity().findViewById(R.id.bottom_navigation);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_TransaksiDriver){
            Intent intent = new Intent(getActivity(), DriverTransactionActivity.class);
            startActivity(intent);
            MenuItem item = nav.getMenu().findItem(R.id.menu_beranda);
            item.setChecked(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}