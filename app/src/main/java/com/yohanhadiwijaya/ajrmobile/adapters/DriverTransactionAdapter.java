package com.yohanhadiwijaya.ajrmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.yohanhadiwijaya.ajrmobile.R;
import com.yohanhadiwijaya.ajrmobile.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DriverTransactionAdapter extends RecyclerView.Adapter<DriverTransactionAdapter.ViewHolder> implements Filterable {

    private List<Transaction> driverTransactionList, filteredDriverTransactionList;
    private Context context;

    public DriverTransactionAdapter(List<Transaction> driverTransactionList, Context context) {
        this.driverTransactionList = driverTransactionList;
        filteredDriverTransactionList = new ArrayList<>(driverTransactionList);
        this.context = context;
    }

    @NonNull
    @Override
    public DriverTransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_reservasidriver, parent, false);
        return new DriverTransactionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverTransactionAdapter.ViewHolder holder, int position) {
        Transaction driverTransaction = filteredDriverTransactionList.get(position);

        Glide.with(context)
                .load("http://192.168.1.5:8000/storage/" + driverTransaction.getGet_mobil().getFoto_mobil())
                .into(holder.imgMobil);
        holder.tvIDTransaksi.setText("Transaksi: #"+driverTransaction.getId_reservasi());
        holder.tvJenisTransaksi.setText(driverTransaction.getJenis_reservasi());
        holder.tvNamaMobilTransaksi.setText(driverTransaction.getGet_mobil().getNama_mobil());
        holder.tvTanggalMulai.setText(driverTransaction.getTanggal_mulai());
        holder.tvTanggalSelesai.setText(driverTransaction.getTanggal_selesai());
        holder.tvDriver.setText(driverTransaction.getGet_driver().getNama_driver());
        holder.tvTarifDriver.setText(String.valueOf(String.format("%.2f",driverTransaction.getTarif_driver())));
        holder.tvStatusTransaksi.setText(driverTransaction.getStatus_reservasi());
        if(driverTransaction.getRating_driver() != null)
            holder.rating.setRating(Float.parseFloat(String.valueOf(driverTransaction.getRating_driver())));
        else
            holder.rating.setRating(0);
    }

    @Override
    public int getItemCount() {
        return filteredDriverTransactionList.size();
    }

    public void setDriverTransactionList(List<Transaction> driverTransactionList) {
        this.driverTransactionList = driverTransactionList;
        filteredDriverTransactionList = new ArrayList<>(driverTransactionList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<Transaction> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(driverTransactionList);
                } else {
                    for (Transaction driverTransaction : driverTransactionList) {
                        if (driverTransaction.getId_reservasi().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(driverTransaction);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredDriverTransactionList.clear();
                filteredDriverTransactionList.addAll((List<Transaction>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggalTransaksi, tvIDTransaksi, tvJenisTransaksi, tvNamaMobilTransaksi, tvTanggalMulai, tvTanggalSelesai,
                tvDriver, tvTarifDriver, tvPromo, tvDenda, tvTotalTarif, tvStatusTransaksi;
        ImageView imgMobil;
        RatingBar rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMobil = itemView.findViewById(R.id.iv_gambarMobilTransaksiDriver);
            tvIDTransaksi = itemView.findViewById(R.id.tvIDTransaksiDriver);
            tvJenisTransaksi = itemView.findViewById(R.id.tvJenisTransaksiDriver);
            tvNamaMobilTransaksi = itemView.findViewById(R.id.tvNamaMobilTransaksiDriver);
            tvTanggalMulai = itemView.findViewById(R.id.tvTanggalMulaiDriver);
            tvTanggalSelesai = itemView.findViewById(R.id.tvTanggalSelesaiDriver);
            tvDriver = itemView.findViewById(R.id.tvNamaDriver);
            tvTarifDriver = itemView.findViewById(R.id.tvTarifDriverTransaksiDriver);
            tvStatusTransaksi = itemView.findViewById(R.id.tvStatusTransaksiDriver);
            rating = itemView.findViewById(R.id.rating_transaksi);
        }
    }
}
