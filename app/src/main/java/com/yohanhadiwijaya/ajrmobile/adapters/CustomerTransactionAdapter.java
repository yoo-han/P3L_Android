package com.yohanhadiwijaya.ajrmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yohanhadiwijaya.ajrmobile.R;
import com.yohanhadiwijaya.ajrmobile.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransactionAdapter extends RecyclerView.Adapter<CustomerTransactionAdapter.ViewHolder> implements Filterable {

    private List<Transaction> customerTransactionList, filteredCustomerTransactionList;
    private Context context;

    public CustomerTransactionAdapter(List<Transaction> customerTransactionList, Context context) {
        this.customerTransactionList = customerTransactionList;
        filteredCustomerTransactionList = new ArrayList<>(customerTransactionList);
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerTransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_reservasicustomer, parent, false);
        return new CustomerTransactionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerTransactionAdapter.ViewHolder holder, int position) {
        Transaction customerTransaction = filteredCustomerTransactionList.get(position);

        Glide.with(context)
                .load("http://192.168.1.5:8000/storage/" + customerTransaction.getGet_mobil().getFoto_mobil())
                .into(holder.imgMobil);
        holder.tvTanggalTransaksi.setText(customerTransaction.getTanggal_transaksi());
        holder.tvIDTransaksi.setText("Transaksi: #"+customerTransaction.getId_reservasi());
        holder.tvJenisTransaksi.setText(customerTransaction.getJenis_reservasi());
        holder.tvNamaMobilTransaksi.setText(customerTransaction.getGet_mobil().getNama_mobil());
        holder.tvTanggalMulai.setText(customerTransaction.getTanggal_mulai());
        holder.tvTanggalSelesai.setText(customerTransaction.getTanggal_selesai());
        if(customerTransaction.getGet_driver() != null)
            holder.tvDriver.setText(customerTransaction.getGet_driver().getNama_driver());
        else
            holder.tvDriver.setText("-");
        holder.tvTarifDriver.setText(String.valueOf(String.format("%.2f",customerTransaction.getTarif_driver())));
        if(customerTransaction.getGet_promo() == null)
            holder.tvPromo.setText("-");
        else
            holder.tvPromo.setText(customerTransaction.getGet_promo().getKode_promo());
        if(customerTransaction.getDenda() == 0.0f)
            holder.tvDenda.setText("-");
        else
            holder.tvDenda.setText("Rp"+String.valueOf(String.format("%.2f",customerTransaction.getDenda())));
        holder.tvTotalTarif.setText("Rp"+ String.valueOf(String.format("%.2f",customerTransaction.getTotal_pembayaran())));
        holder.tvStatusTransaksi.setText(customerTransaction.getStatus_reservasi());
    }

    @Override
    public int getItemCount() {
        return filteredCustomerTransactionList.size();
    }

    public void setCustomerTransactionList(List<Transaction> customerTransactionList) {
        this.customerTransactionList = customerTransactionList;
        filteredCustomerTransactionList = new ArrayList<>(customerTransactionList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<Transaction> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(customerTransactionList);
                } else {
                    for (Transaction customerTransaction : customerTransactionList) {
                        if (customerTransaction.getId_reservasi().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(customerTransaction);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredCustomerTransactionList.clear();
                filteredCustomerTransactionList.addAll((List<Transaction>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggalTransaksi, tvIDTransaksi, tvJenisTransaksi, tvNamaMobilTransaksi, tvTanggalMulai, tvTanggalSelesai,
                tvDriver, tvTarifDriver, tvPromo, tvDenda, tvTotalTarif, tvStatusTransaksi;
        ImageView imgMobil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMobil = itemView.findViewById(R.id.iv_gambarMobilTransaksi);
            tvTanggalTransaksi = itemView.findViewById(R.id.tvTanggalTransaksi);
            tvIDTransaksi = itemView.findViewById(R.id.tvIDTransaksi);
            tvJenisTransaksi = itemView.findViewById(R.id.tvJenisTransaksi);
            tvNamaMobilTransaksi = itemView.findViewById(R.id.tvNamaMobilTransaksi);
            tvTanggalMulai = itemView.findViewById(R.id.tvTanggalMulai);
            tvTanggalSelesai = itemView.findViewById(R.id.tvTanggalSelesai);
            tvDriver = itemView.findViewById(R.id.tvDriver);
            tvTarifDriver = itemView.findViewById(R.id.tvTarifDriver);
            tvPromo = itemView.findViewById(R.id.tvPromo);
            tvDenda = itemView.findViewById(R.id.tvDenda);
            tvTotalTarif = itemView.findViewById(R.id.tvTotalTarif);
            tvStatusTransaksi = itemView.findViewById(R.id.tvStatusTransaksi);
        }
    }
}