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
import com.yohanhadiwijaya.ajrmobile.databinding.FragmentCustomerDashboardBinding;
import com.yohanhadiwijaya.ajrmobile.models.Customer;
import com.yohanhadiwijaya.ajrmobile.models.Mobil;
import com.yohanhadiwijaya.ajrmobile.preferences.CustomerPreference;

public class CustomerDashboardFragment extends Fragment implements View.OnClickListener {

    private FragmentCustomerDashboardBinding binding;
    private CustomerPreference customerPreference;
    private Customer customer;
    private BottomNavigationView nav;

    public CustomerDashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_customer_dashboard, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customerPreference = new CustomerPreference(this.getActivity().getApplicationContext());
        customer = customerPreference.GetCustomerNow();

        binding.btnPromo.setOnClickListener(this);
        binding.btnCar.setOnClickListener(this);
        binding.btnTransaksiCustomer.setOnClickListener(this);
        nav = getActivity().findViewById(R.id.bottom_navigation);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_Promo){
            Intent intent = new Intent(getActivity(), PromoActivity.class);
            startActivity(intent);
            MenuItem item = nav.getMenu().findItem(R.id.menu_beranda);
            item.setChecked(true);
        } else if(view.getId() == R.id.btn_Car){
            Intent intent = new Intent(getActivity(), MobilActivity.class);
            startActivity(intent);
            MenuItem item = nav.getMenu().findItem(R.id.menu_beranda);
            item.setChecked(true);
        } else if(view.getId() == R.id.btn_TransaksiCustomer) {
            Intent intent = new Intent(getActivity(), CustomerTransactionActivity.class);
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