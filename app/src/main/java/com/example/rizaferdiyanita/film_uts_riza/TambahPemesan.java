package com.example.rizaferdiyanita.film_uts_riza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rizaferdiyanita.film_uts_riza.entitas.Pemesan;
import com.example.rizaferdiyanita.film_uts_riza.models.PemesanModel;

public class TambahPemesan extends AppCompatActivity {
    // Data
    private PemesanModel mPemesan;

    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private EditText txtJudul;
    private EditText txtJumlah;
    private Button btnSimpan;
    private Button btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pemesan);

        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mPemesan = new PemesanModel(this);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.txtJudul = (EditText) this.findViewById(R.id.txtJudul);
        this.txtJumlah = (EditText) this.findViewById(R.id.txtJumlah);
        this.btnSimpan = (Button) this.findViewById(R.id.btnSimpan);
        this.btnBatal = (Button) this.findViewById(R.id.btnBatal);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnSimpan)
        {
            this.tambahPemesan();
        }
        else if(b == this.btnBatal)
        {
            this.finish();
        }
    }
    private void tambahPemesan()
    {
        // Disini dilakukan penyimpanan kontak baru ke database
        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        String judul = this.txtJudul.getText().toString();
        String jumlah = this.txtJumlah.getText().toString();

        Pemesan pemesanBaru = new Pemesan();
        pemesanBaru.setNama(nama);
        pemesanBaru.setNomor(nomor);
        pemesanBaru.setJudul(judul);
        pemesanBaru.setJumlah(jumlah);

        //sebelum diedit
        //this.mKontak.insert(kontakBaru);

        //Toast.makeText(this, "Kontak berhasil ditambahkan", Toast.LENGTH_SHORT).show();

        //this.btnBatal.setText("Kembali");

        if(nama.equals("") && nomor.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(nama.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(nomor.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(judul.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(jumlah.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            this.mPemesan.insert(pemesanBaru);
            Toast.makeText(this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            this.btnBatal.setText("Kembali");
        }
    }
}
