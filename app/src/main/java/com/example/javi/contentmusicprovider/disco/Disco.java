package com.example.javi.contentmusicprovider.disco;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.javi.contentmusicprovider.base_de_datos.Contrato;

/**
 * Created by javi on 01/01/2016.
 */
public class Disco {

    private long id;
    private String nombre;
    private long idInterprete;

    public Disco() {
    }

    public Disco(long id, String nombre, long idInterprete) {
        this.id = id;
        this.nombre = nombre;
        this.idInterprete = idInterprete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdInterprete() {
        return idInterprete;
    }

    public void setIdInterprete(long idInterprete) {
        this.idInterprete = idInterprete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disco disco = (Disco) o;

        return id == disco.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Disco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idInterprete=" + idInterprete +
                '}';
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaDisco._ID,this.id);
        cv.put(Contrato.TablaDisco.NOMBRE,this.nombre);
        cv.put(Contrato.TablaDisco.IDINTERPRETE,this.idInterprete);
        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaDisco._ID));
        this.nombre = c.getString(c.getColumnIndex(Contrato.TablaDisco.NOMBRE));
        this.idInterprete= c.getLong(c.getColumnIndex(Contrato.TablaDisco.IDINTERPRETE));
    }
}
