package com.example.evidencijaprojekta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class OsobaAzurirajFragment extends Fragment {

    EditText prezimeOsobe, imeOsobe, OIBOsobe;
    Button pohrani;
    private Context context;
    DbHandler db, readDb;
    ArrayList<String> listaOsoba;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_osoba_azuriraj, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prezimeOsobe = (EditText) view.findViewById(R.id.PrezimeUnos);
        imeOsobe = (EditText) view.findViewById(R.id.ImeUnos);
        pohrani = (Button) view.findViewById(R.id.PohraniGumb);

        view.findViewById(R.id.PohraniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prezime = prezimeOsobe.getText().toString();
                String ime = imeOsobe.getText().toString();
                String OIB = OIBOsobe.getText().toString();

                db = new DbHandler(context);
                // db.editOsoba(prezime, ime);
            }
        });



        view.findViewById(R.id.PovratniGumbAzuriraj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OsobaAzurirajFragment.this)
                        .navigate(R.id.action_OsobaAzurirajFragment_to_OsobaUrediFragment);
            }
        });
    }
}
