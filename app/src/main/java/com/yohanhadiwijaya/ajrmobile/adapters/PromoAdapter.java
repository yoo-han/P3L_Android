package com.yohanhadiwijaya.ajrmobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yohanhadiwijaya.ajrmobile.R;
import com.yohanhadiwijaya.ajrmobile.models.Promo;

import java.util.ArrayList;
import java.util.List;

public class PromoAdapter extends RecyclerView.Adapter<PromoAdapter.ViewHolder> implements Filterable {

    private List<Promo> promoList, filteredPromoList;
    private Context context;
    public PromoAdapter(List<Promo> promoList, Context context) {
        this.promoList = promoList;
        filteredPromoList = new ArrayList<>(promoList);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_promo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Promo promo = filteredPromoList.get(position);
        holder.tvJenis.setText(promo.getJenis_promo());
        holder.tvKode.setText(promo.getKode_promo()+"-"+promo.getPotongan_promo());
        holder.tvKeterangan.setText(String.valueOf(promo.getKeterangan_promo()));
    }

    @Override
    public int getItemCount() {
        return filteredPromoList.size();
    }

    public void setPromoList(List<Promo> promoList) {
        this.promoList = promoList;
        filteredPromoList = new ArrayList<>(promoList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<Promo> filtered = new ArrayList<>();
                if (charSequenceString.isEmpty()) {
                    filtered.addAll(promoList);
                } else {
                    for (Promo promo : promoList) {
                        if (promo.getKode_promo().toLowerCase().contains(charSequenceString.toLowerCase()))
                            filtered.add(promo);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults
                    filterResults) {
                filteredPromoList.clear();
                filteredPromoList.addAll((List<Promo>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJenis, tvKode, tvKeterangan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJenis = itemView.findViewById(R.id.tvJenisPromo);
            tvKode = itemView.findViewById(R.id.tvKodePotonganPromo);
            tvKeterangan = itemView.findViewById(R.id.tvKeteranganPromo);
        }
    }
}
