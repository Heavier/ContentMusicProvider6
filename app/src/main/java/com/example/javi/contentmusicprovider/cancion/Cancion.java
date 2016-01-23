package com.example.javi.contentmusicprovider.cancion;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.javi.contentmusicprovider.base_de_datos.Contrato;

/**
 * Created by javi on 01/01/2016.
 */
public class Cancion {

    private long id;
    private String titulo;
    private long idDisco;

    public Cancion() {
    }

    public Cancion(long id, String titulo, long idDisco) {
        this.id = id;
        this.titulo = titulo;
        this.idDisco = idDisco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(long idDisco) {
        this.idDisco = idDisco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancion cancion = (Cancion) o;

        return id == cancion.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", idDisco=" + idDisco +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public ContentValues getContentValues(){
        ContentValues cv = new ContentValues();
        cv.put(Contrato.TablaCancion._ID,this.id);
        cv.put(Contrato.TablaCancion.TITULO,this.titulo);
        cv.put(Contrato.TablaCancion.IDDISCO,this.idDisco);
        return cv;
    }

    public void set(Cursor c){
        this.id = c.getLong(c.getColumnIndex(Contrato.TablaCancion._ID));
        this.titulo = c.getString(c.getColumnIndex(Contrato.TablaCancion.TITULO));
        this.idDisco= c.getLong(c.getColumnIndex(Contrato.TablaCancion.IDDISCO));

    }
}
