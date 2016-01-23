package com.example.javi.contentmusicprovider.cancion;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.javi.contentmusicprovider.base_de_datos.Ayudante;
import com.example.javi.contentmusicprovider.base_de_datos.Contrato;

/**
 * Created by javi on 16/01/2016.
 */
public class ProveedorCanciones extends ContentProvider {

    private Ayudante abd;

    @Override
    public boolean onCreate() {
        abd = new Ayudante(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (Contrato.TablaCancion.convierteUri2Int.match(uri)){
            case Contrato.TablaCancion.CANCIONES:
                return Contrato.TablaCancion.MULTIPLE_MIME;
            case Contrato.TablaCancion.CANCIONES_ID:
                return Contrato.TablaCancion.SINGLE_MIME;
            default:
                throw new IllegalArgumentException("Tipo de actividad desconocida " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // Comprobar que la uri utilizada para hacer la insercion es correcta
        if (Contrato.TablaCancion.convierteUri2Int.match(uri) != Contrato.TablaCancion.CANCIONES) {
            throw new IllegalArgumentException("URI desconocida : " + uri);//SI no es correcta la Uri
        }

        //Si el ContentValues es nulo, crea un ContentValues
        ContentValues contentValues;
        if (values != null) {
            contentValues = new ContentValues(values);
        } else {
            contentValues = new ContentValues();
        }
        //Validar

        // Inserción de nueva fila
        SQLiteDatabase db = abd.getWritableDatabase();//Conectamos a la base de datos en modo escritura
        long rowId = db.insert(Contrato.TablaCancion.TABLA, null, contentValues);
        if (rowId > 0) {
            //Si se ha insertado el elemento correctamente, entonces devolvemos la uri del elemento que se acaba de insertar
            Uri uri_actividad = ContentUris.withAppendedId(Contrato.TablaCancion.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(uri_actividad, null);
            return uri_actividad;
        }
        throw new SQLException("Error al insertar fila en : " + uri);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }


    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        // Obtener base de datos
        SQLiteDatabase db = abd.getReadableDatabase();
        // Comparar Uri
        int match = Contrato.TablaCancion.convierteUri2Int.match(uri);

        Cursor c;

        switch (match) {
            case Contrato.TablaCancion.CANCIONES:
                // Consultando todos los registros
                c = db.query(Contrato.TablaCancion.TABLA, projection, selection, selectionArgs, null, null, sortOrder);
                c.setNotificationUri(getContext().getContentResolver(), Contrato.TablaCancion.CONTENT_URI);
                break;
            case Contrato.TablaCancion.CANCIONES_ID:
                // Consultando un solo registro basado en el Id del Uri
                long idActividad = ContentUris.parseId(uri);
                c = db.query(Contrato.TablaCancion.TABLA, projection, Contrato.TablaCancion._ID + " = " + idActividad,
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(getContext().getContentResolver(), Contrato.TablaCancion.CONTENT_URI);
                break;
            default:
                throw new IllegalArgumentException("URI no soportada: " + uri);
        }
        return c;
    }

}