package com.example.rizaferdiyanita.film_uts_riza.models;

import android.content.Context;
import android.database.Cursor;

import com.example.rizaferdiyanita.film_uts_riza.entitas.Pemesan;
import com.example.rizaferdiyanita.film_uts_riza.liberaries.DbHelper;

import java.util.ArrayList;

public class PemesanModel {

        private Context context;
        private DbHelper db;

        public PemesanModel(Context context)
        {
            this.context = context;
            this.db = new DbHelper(this.context);
        }
        public ArrayList<Pemesan> selectAll()
        {
            String sql = "SELECT * FROM pemesan";
            ArrayList<Pemesan> semuaPemesan = new ArrayList<>();
            Cursor cursor = this.db.executeRead(sql);

            if(cursor.getCount()>0)
            {
                cursor.moveToFirst();

                do
                {
                    int id = cursor.getInt(0);
                    String nama = cursor.getString(1);
                    String nomor = cursor.getString(2);
                    String judul = cursor.getString(3);
                    String jumlah = cursor.getString(4);

                    Pemesan p = new Pemesan();

                    p.setId(id);
                    p.setNama(nama);
                    p.setNomor(nomor);
                    p.setJudul(judul);
                    p.setJumlah(jumlah);

                    semuaPemesan.add(p);
                }
                while (cursor.moveToNext());
            }
            return semuaPemesan;
        }
        public void insert(Pemesan p)
        {
            String nama = p.getNama();
            String nomor = p.getNomor();
            String judul = p.getJudul();
            String jumlah = p.getJumlah();

            String sql = "INSERT INTO pemesan(nama, nomor, judul, jumlah) VALUES('" + nama + "', '" + nomor + "', '"+ judul +"', '"+ jumlah +"')";

            this.db.executeWrite(sql);
        }
        public void update(Pemesan p)
        {
            if(p.getId() < 0)
                return;
            int id = p.getId();

            String nama = p.getNama();
            String nomor = p.getNomor();
            String judul = p.getJudul();
            String jumlah = p.getJumlah();

            String sql = "UPDATE pemesan SET nama = '" + nama + "', nomor = '" + nomor + "', judul = '" + judul + "', jumlah = '"+ jumlah +"' WHERE id = '" + id + "'";

            this.db.executeWrite(sql);
        }
        public Pemesan selectOne(int id)
        {
            String sql = "SELECT * FROM pemesan WHERE id = '" + id + "'";
            Cursor cursor = this.db.executeRead(sql);

            if(cursor.getCount() > 0)
            {
                cursor.moveToFirst();

                Pemesan p = new Pemesan();

                p.setId(cursor.getInt(0));
                p.setNama(cursor.getString(1));
                p.setNomor(cursor.getString(2));
                p.setJudul(cursor.getString(3));
                p.setJumlah(cursor.getString(4));
                return p;
            }
            return null;
        }
        public void delete(Pemesan p)
        {
            if(p.getId() < 0) // ID negatif -> Bukan dari tabel
                return;
            String sql = "DELETE FROM pemesan WHERE id = '" + p.getId() + "'";
            this.db.executeWrite(sql);
        }

    }

