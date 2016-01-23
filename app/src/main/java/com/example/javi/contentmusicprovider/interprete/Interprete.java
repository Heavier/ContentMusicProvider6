package com.example.javi.contentmusicprovider.interprete;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.javi.contentmusicprovider.base_de_datos.Contrato;

/**
 * Created by javi on 01/01/2016.
 */
public class Interprete {

    private long id;
    private String nombre;

    public Interprete() {
    }

    public Interprete(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interprete that = (Interprete) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Interprete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaInterprete._ID,this.id);
        cv.put(Contrato.TablaInterprete.NOMBRE,this.nombre);
        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaInterprete._ID));
        this.nombre = c.getString(c.getColumnIndex(Contrato.TablaInterprete.NOMBRE));
    }
}
