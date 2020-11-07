package com.example.evidencijaprojekta;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class OsobaFragment extends Fragment {

    EditText prezimeOsobe, imeOsobe, OIBOsobe;
    Button pohrani;
    private Context context;
    DbHandler db, readDb;
    ArrayList<String> listaOsoba;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_osoba, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prezimeOsobe = (EditText) view.findViewById(R.id.PrezimeUnos);
        imeOsobe = (EditText) view.findViewById(R.id.ImeUnos);
        OIBOsobe = (EditText) view.findViewById(R.id.OIBUnos);
        pohrani = (Button) view.findViewById(R.id.PohraniGumb);

        view.findViewById(R.id.PohraniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prezime = prezimeOsobe.getText().toString();
                String ime = imeOsobe.getText().toString();
                String OIB = OIBOsobe.getText().toString();

                Osoba novaOsoba = new Osoba(prezime, ime, OIB);

                db = new DbHandler(context);
                db.addOsoba(novaOsoba);
            }
        });



        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OsobaFragment.this)
                        .navigate(R.id.action_OsobaFragment_to_FirstFragment);
            }
        });
    }
}
