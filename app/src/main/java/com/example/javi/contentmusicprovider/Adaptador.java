package com.example.javi.contentmusicprovider;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.javi.contentmusicprovider.base_de_datos.Contrato;

public class Adaptador extends CursorAdapter {

private Cursor cursor;

    public Adaptador(Context context, Cursor cursor) {
        super(context, cursor, 0);
        this.cursor=cursor;
    }


    @Override
    public void bindView(View view, Context context, Cursor cur) {
        TextView txt = (TextView) view.findViewById(R.id.tvCancion);
        txt.setText(cur.getString(cur.getColumnIndex(Contrato.TablaCancion.TITULO)));
    }

    @Override
    public View newView(Context context, Cursor cur, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.item, parent, false);
    }
}
