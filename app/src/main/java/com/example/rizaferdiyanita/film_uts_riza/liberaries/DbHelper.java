package com.example.rizaferdiyanita.film_uts_riza.liberaries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbHelper(Context context){
        // Database yang akan dibuat bernama kontak.db dengan versi = 1
        // File tersebut berada di: /data/data/packagename/databases/
        super(context, "pemesan.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS pemesan(id integer PRIMARY KEY, jam VARCHAR, nomor VARCHAR, judul VARCHAR, jumlah VARCHAR)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS pemesan";
        db.execSQL(sql);
        this.onCreate(db);

    }
    public Cursor executeRead(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
    public void executeWrite(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
