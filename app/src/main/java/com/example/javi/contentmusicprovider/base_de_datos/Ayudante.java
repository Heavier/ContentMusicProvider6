package com.example.javi.contentmusicprovider.base_de_datos;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.example.javi.contentmusicprovider.Principal;
import com.example.javi.contentmusicprovider.cancion.Cancion;
import com.example.javi.contentmusicprovider.disco.Disco;
import com.example.javi.contentmusicprovider.interprete.Interprete;

/**
 * Created by javi on 01/01/2016.
 */
public class Ayudante extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "canciones.sqlite";

    public static final int DATABASE_VERSION = 1;

    public Ayudante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql = " create table " + Contrato.TablaCancion.TABLA
                + " (" + Contrato.TablaCancion._ID
                + " integer primary key , "
                + Contrato.TablaCancion.TITULO + " text , "
                + Contrato.TablaCancion.IDDISCO + " integer )";
        Log.v("SQLAAD", sql);
        db.execSQL(sql);

        sql = " create table " + Contrato.TablaDisco.TABLA
                + " (" + Contrato.TablaDisco._ID
                + " integer , "
                + Contrato.TablaDisco.NOMBRE + " text , "
                + Contrato.TablaDisco.IDINTERPRETE + " integer )";
        Log.v("SQLAAD", sql);
        db.execSQL(sql);

        sql = " create table " + Contrato.TablaInterprete.TABLA
                + " (" + Contrato.TablaInterprete._ID
                + " integer , "
                + Contrato.TablaInterprete.NOMBRE + " text )";
        Log.v("SQLAAD", sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " drop table if exists " + Contrato.TablaCancion.TABLA;
        db.execSQL(sql);
        sql = " drop table if exists " + Contrato.TablaInterprete.TABLA;
        db.execSQL(sql);
        sql = " drop table if exists " + Contrato.TablaDisco.TABLA;
        db.execSQL(sql);
        onCreate(db);
    }
}
