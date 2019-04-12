package com.example.rizaferdiyanita.film_uts_riza.entitas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rizaferdiyanita.film_uts_riza.R;
import com.example.rizaferdiyanita.film_uts_riza.models.Daftar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterDaftar extends RecyclerView.Adapter<AdapterDaftar.ViewHolder> {

    private List<Daftar> daftarList;

    public AdapterDaftar(List<Daftar> daftarList) {

        this.daftarList = daftarList;
    }

    @NonNull
    @Override
    public AdapterDaftar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View daftarView = inflater.inflate(R.layout.item_daftar, viewGroup, false);

        return new AdapterDaftar.ViewHolder(daftarView);
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterDaftar.ViewHolder viewHolder, int i) {
        Daftar daftars = daftarList.get(i);

        if (daftars.getImg() != null) {
            Picasso.get().load(daftars.getImg()).into(viewHolder.imageView);
        } else {
            Picasso.get().load(daftars.getImg_local()).into(viewHolder.imageView);
        }

        viewHolder.textView.setText(daftars.getTitle());
        viewHolder.descView.setText(daftars.getDesc());
    }
    @Override
    public int getItemCount() {
        return daftarList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView descView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_daftar_img);
            textView = itemView.findViewById(R.id.item_daftar_title);
            descView = itemView.findViewById(R.id.item_daftar_desc);
        }
    }
}
