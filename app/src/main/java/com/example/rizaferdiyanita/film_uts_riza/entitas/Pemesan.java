package com.example.rizaferdiyanita.film_uts_riza.entitas;

public class Pemesan {

    private int id;
    private String nama;
    private String nomor;
    private String judul;
    private String jumlah;

    public Pemesan()
    {
        this.id=-1;
    }

    public int getId() {

        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNama()
    {
        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getNomor() {

        return nomor;
    }

    public void setNomor(String nomor) {

        this.nomor = nomor;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getJumlah() {
        return jumlah;
    }

}

