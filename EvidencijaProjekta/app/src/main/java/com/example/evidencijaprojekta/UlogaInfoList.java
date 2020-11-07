package com.example.evidencijaprojekta;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class UlogaInfoList {
    DbHandler readDb;
    private Context context;
    ListView listView;
    View view;
    ArrayList<String> listaUloga;


    public UlogaInfoList(Context context, View view){
        this.context = context;
        this.view = view;
    }

    public ArrayList<String> getList(){
        readDb = new DbHandler(context);
        Cursor cursor = readDb.readAllFromTableUloga();
        listView = (ListView) view.findViewById(R.id.ListaUloga);
        listaUloga = new ArrayList<String>();

        try {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                String idUloge = cursor.getString(0);
                String nazUloge = cursor.getString(1);
                listaUloga.add(idUloge + ";"  + nazUloge);
            }
        } finally {
            cursor.close();
        }

        return listaUloga;
    }
}
