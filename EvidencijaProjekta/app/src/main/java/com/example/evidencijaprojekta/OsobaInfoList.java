package com.example.evidencijaprojekta;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OsobaInfoList {
    DbHandler readDb;
    private Context context;
    ListView listView;
    View view;
    ArrayList<String> listaOsoba;

    public OsobaInfoList(Context context, View view){
        this.context = context;
        this.view = view;
    }

    public ArrayList<String> getList(){
        readDb = new DbHandler(context);
        Cursor cursor = readDb.readAllFromTableOsoba();
        listView = (ListView) view.findViewById(R.id.ListaOsoba);
        listaOsoba = new ArrayList<String>();

        try {
            cursor.moveToFirst();
            while (cursor.moveToNext()) {
                String id = cursor.getString(0);
                String prezime = cursor.getString(1);
                String ime = cursor.getString(2);
                String OIB = cursor.getString(3);
                listaOsoba.add(id + ";"  + prezime + ";" + ime + ";" + OIB);
                // map.put(id, new HashMap(){{put("prezime", prezime);}});
                // map.get(id).put("ime", ime);
                // map.get(id).put("OIB", OIB);
            }
        } finally {
            cursor.close();
        }

        return listaOsoba;
    }
}
