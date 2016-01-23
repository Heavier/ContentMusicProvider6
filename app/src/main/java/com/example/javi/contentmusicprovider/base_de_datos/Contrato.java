package com.example.javi.contentmusicprovider.base_de_datos;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by javi on 01/01/2016.
 */
public class Contrato {

    public Contrato() {
    }

    public static abstract class TablaCancion implements BaseColumns{
        public static final String TABLA = "cancion";
        public static final String TITULO = "titulo";
        public static final String IDDISCO = "iddisco";

        public final static String AUTHORITY = "com.example.javi.contentmusicprovider.cancion.ProveedorCanciones";
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;

        public static final UriMatcher convierteUri2Int;
        public static final int CANCIONES = 1;
        public static final int CANCIONES_ID = 2;

        static{
            convierteUri2Int = new UriMatcher(UriMatcher.NO_MATCH);
            convierteUri2Int.addURI(Contrato.TablaCancion.AUTHORITY, Contrato.TablaCancion.TABLA, CANCIONES);
            convierteUri2Int.addURI(Contrato.TablaCancion.AUTHORITY, Contrato.TablaCancion.TABLA + "/#", CANCIONES_ID);
        }
    }

    public static abstract class TablaInterprete implements BaseColumns{
        public static final String TABLA = "interprete";
        public static final String NOMBRE = "nombre";

        public final static String AUTHORITY = "com.example.javi.contentmusicprovider.interprete.ProveedorInterpretes";
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;

        public static final UriMatcher convierteUri2Int;
        public static final int INTERPRETES = 1;
        public static final int INTERPRETES_ID = 2;

        static{
            convierteUri2Int = new UriMatcher(UriMatcher.NO_MATCH);
            convierteUri2Int.addURI(Contrato.TablaInterprete.AUTHORITY, Contrato.TablaInterprete.TABLA, INTERPRETES);
            convierteUri2Int.addURI(Contrato.TablaInterprete.AUTHORITY, Contrato.TablaInterprete.TABLA + "/#", INTERPRETES_ID);
        }
    }

    public static abstract class TablaDisco implements BaseColumns{
        public static final String TABLA = "disco";
        public static final String NOMBRE = "nombre";
        public static final String IDINTERPRETE = "idinterprete";

        public final static String AUTHORITY = "com.example.javi.contentmusicprovider.disco.ProveedorDiscos";
        public final static Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/" + TABLA);
        public final static String SINGLE_MIME =
                "vnd.android.cursor.item/vnd." + AUTHORITY + TABLA;
        public final static String MULTIPLE_MIME =
                "vnd.android.cursor.dir/vnd." + AUTHORITY + TABLA;

        public static final UriMatcher convierteUri2Int;
        public static final int DISCOS = 1;
        public static final int DISCOS_ID = 2;

        static{
            convierteUri2Int = new UriMatcher(UriMatcher.NO_MATCH);
            convierteUri2Int.addURI(Contrato.TablaDisco.AUTHORITY, Contrato.TablaDisco.TABLA, DISCOS);
            convierteUri2Int.addURI(Contrato.TablaDisco.AUTHORITY, Contrato.TablaDisco.TABLA + "/#", DISCOS_ID);
        }
    }
}
