package com.example.rizaferdiyanita.film_uts_riza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rizaferdiyanita.film_uts_riza.entitas.AdapterDaftar;
import com.example.rizaferdiyanita.film_uts_riza.models.Daftar;

import java.util.ArrayList;
import java.util.List;

public class DaftarFilm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_film);

        List<Daftar> daftarList= new ArrayList<>();
        daftarList.add(new Daftar("film_1", "Yowes Ben2","Rp. 40.000",R.drawable.yowesben));
        daftarList.add(new Daftar("film_2", "Dilan","Rp. 40.000", R.drawable.dilan));
        daftarList.add(new Daftar("film_3", "Five Feet Apart","Rp. 40.000", R.drawable.fivefeetapart));
        daftarList.add(new Daftar("film_4", "My Stupit Bos","Rp. 40.000" ,R.drawable.mystupitboss));
        daftarList.add(new Daftar("film_5", "Captain marvel","Rp. 40.000" ,R.drawable.captainmarvel));
        daftarList.add(new Daftar("film_6", "Meet me after sunset","Rp. 40.000" , R.drawable.meetmeaftersunset));
        daftarList.add(new Daftar("film_7", "Balik kanan barcelona", "Rp. 40.000", R.drawable.belokkananbarcelona));
        daftarList.add(new Daftar("film_8", "Delivery man", "Rp. 40.000", R.drawable.deliveryman));


        AdapterDaftar adapterDaftar= new AdapterDaftar(daftarList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_daftar);
        recyclerView.setAdapter(adapterDaftar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
