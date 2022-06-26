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
import com.yohanhadiwijaya.ajrmobile.models.Mobil;

import java.util.ArrayList;
import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.ViewHolder> implements Filterable {

    private List<Mobil> mobilList, filteredMobilList;
    private Context context;
    public MobilAdapter(List<Mobil> mobilList, Context context) {
        this.mobilList = mobilList;
        filteredMobilList = new ArrayList<>(mobilList);
        this.context = context;
    }

    @NonNull
    @Override
    public MobilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_mobil, parent, false);
        return new MobilAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobilAdapter.ViewHolder holder, int position) {
        Mobil mobil = filteredMobilList.get(position);

        Glide.with(context)
                .load("http://192.168.1.5:8000/storage/"+mobil.getFoto_mobil())
                .into(holder.imgMobil);
        holder.tvTipe.setText(mobil.getTipe_mobil());
        holder.tvNama.setText(mobil.getNama_mobil());
        holder.tvTransmisi.setText(mobil.getJenis_transmisi());
        holder.tvWarna.setText(mobil.getWarna_mobil());
        holder.tvBahanBakar.setText(mobil.getJenis_bahan_bakar());
        holder.tvFasilitas.setText(mobil.getFasilitas());
        holder.tvHarga.setText("Rp" + String.valueOf(String.format("%.2f",mobil.getHarga_sewa())));
    }

    @Override
    public int getItemCount() {
        return filteredMobilList.size();
    }

    public void setMobilList(List<Mobil> mobilList) {
        this.mobilList = mobilList;
        filteredMobilList = new ArrayList<>(mobilList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<Mobil> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(mobilList);
                } else {
                    for (Mobil mobil : mobilList) {
                        if (mobil.getNama_mobil().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(mobil);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredMobilList.clear();
                filteredMobilList.addAll((List<Mobil>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipe, tvNama, tvTransmisi, tvWarna, tvBahanBakar, tvFasilitas, tvHarga;
        ImageView imgMobil;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMobil = itemView.findViewById(R.id.iv_gambarMobil);
            tvTipe = itemView.findViewById(R.id.tvTipeMobil);
            tvNama = itemView.findViewById(R.id.tvNamaMobil);
            tvTransmisi = itemView.findViewById(R.id.tvJenisTransmisi);
            tvWarna = itemView.findViewById(R.id.tvWarnaMobil);
            tvBahanBakar = itemView.findViewById(R.id.tvBahanBakarMobil);
            tvFasilitas = itemView.findViewById(R.id.tvFasilitasMobil);
            tvHarga = itemView.findViewById(R.id.tvHargaMobil);
        }
    }
}
