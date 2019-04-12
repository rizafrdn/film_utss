package com.example.rizaferdiyanita.film_uts_riza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.rizaferdiyanita.film_uts_riza.entitas.Pemesan;
import com.example.rizaferdiyanita.film_uts_riza.models.PemesanModel;

import java.util.ArrayList;

public class LihatPemesan extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // Data
    private PemesanModel mPemesan;
    private ArrayList<Pemesan> allPemesan;
    private ArrayList<String> daftarNama;

    // Komponen
    private ListView lstDaftarPemesan;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pemesan);

        this.initData();
        this.initComponents();
    }
    protected void onStart(){
        super.onStart();
        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.daftarNama = new ArrayList<>();

        this.mPemesan = new PemesanModel(this);
        this.allPemesan = this.mPemesan.selectAll();

        for(Pemesan k : allPemesan) {
            this.daftarNama.add(k.getNama());
        }
    }
    private void initComponents()
    {
        this.lstDaftarPemesan = (ListView) this.findViewById(R.id.lstDaftarPemesan);
        this.btnOk = (Button) this.findViewById(R.id.btnOk);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.daftarNama);

        this.lstDaftarPemesan.setAdapter(adapter);

        this.lstDaftarPemesan.setOnItemClickListener(this);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnOk)
            this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int id = this.allPemesan.get(i).getId();
        Intent intent = new Intent(this, DetailPemesan.class);

        intent.putExtra("selectedContactId", id);

        this.startActivity(intent);
    }
}