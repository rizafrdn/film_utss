package com.example.rizaferdiyanita.film_uts_riza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rizaferdiyanita.film_uts_riza.entitas.Pemesan;
import com.example.rizaferdiyanita.film_uts_riza.models.PemesanModel;

public class DetailPemesan extends AppCompatActivity {
    // Data
    private PemesanModel mPemesan;
    private Pemesan selectedPemesan;
    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private EditText txtJudul;
    private EditText txtJumlah;
    private Button btnUbah;
    private Button btnHapus;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesan);

        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mPemesan = new PemesanModel(this);
        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);

        this.selectedPemesan = this.mPemesan.selectOne(selectedContactId);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.txtJudul = (EditText) this.findViewById(R.id.txtJudul);
        this.txtJumlah = (EditText) this.findViewById(R.id.txtJumlah);
        this.btnUbah = (Button) this.findViewById(R.id.btnUbah);
        this.btnHapus = (Button) this.findViewById(R.id.btnHapus);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);


        this.txtNama.setText(this.selectedPemesan.getNama());
        this.txtNomor.setText(this.selectedPemesan.getNomor());
        this.txtJudul.setText(this.selectedPemesan.getJudul());
        this.txtJumlah.setText(this.selectedPemesan.getJumlah());
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnUbah)
        {
            this.ubahKontak();
        }
        else if(b == this.btnHapus)
        {
            this.hapusKontak();
        }
        else if(b == this.btnKembali)
        {
            this.finish();
        }
    }
    private void ubahKontak()
    {
        // Logic untuk meng-UPDATE kontak diletakkan disini..
        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        String judul = this.txtJudul.getText().toString();
        String jumlah = this.txtJumlah.getText().toString();

        this.selectedPemesan.setNama(nama);
        this.selectedPemesan.setNomor(nomor);
        this.selectedPemesan.setJudul(judul);
        this.selectedPemesan.setJumlah(jumlah);

        this.mPemesan.update(this.selectedPemesan);
        this.resetFields("Data berhasil diperbarui!", false);
    }

    private void resetFields(String pesan, boolean clear) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
        if(clear)
        {
            this.txtNama.setText("");
            this.txtNomor.setText("");
            this.txtJudul.setText("");
            this.txtJumlah.setText("");
        }
    }

    private void hapusKontak()
    {
        // Hapus kontak disini..
        this.mPemesan.delete(this.selectedPemesan);
        this.resetFields("Data dihapus..", true);
        this.btnHapus.setEnabled(false);

        Intent intent = new Intent(this, LihatPemesan.class);
        this.startActivity(intent);
    }
}

