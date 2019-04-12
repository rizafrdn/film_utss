package com.example.rizaferdiyanita.film_uts_riza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    private Button btnLihatPemesan;
    private Button btnTambahPemesan;
    private Button btnDaftarFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.initComponents();
    }

    private void initComponents() {
        this.btnLihatPemesan = (Button) this.findViewById(R.id.btnLihatPemesan);
        this.btnTambahPemesan = (Button) this.findViewById(R.id.btnTambahPemesan);
        this.btnDaftarFilm = this.findViewById(R.id.btnDaftarfilm);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;

        if(b == this.btnLihatPemesan)
        {
            this.openLihatPemesanActivity();
        }
        else if(b == this.btnTambahPemesan)
        {
            this.openTambahPemesanActivity();
        }
        else if(b == this.btnDaftarFilm)
        {
            this.openDaftarFilmActivity();
        }
    }

    private void openLihatPemesanActivity()
    {
        Intent i = new Intent(this, LihatPemesan.class);
        this.startActivity(i);
    }
    private void openTambahPemesanActivity()
    {
        Intent i = new Intent(this, TambahPemesan.class);
        this.startActivity(i);
    }
    private void openDaftarFilmActivity()
    {
        Intent i = new Intent(this, DaftarFilm.class);
        this.startActivity(i);
    }
}

