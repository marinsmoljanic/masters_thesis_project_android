package com.example.evidencijaprojekta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ProjektFragment extends Fragment {
    EditText nazProjekta, opisProjekta;
    DatePicker datPocetka, datZavrsetka;
    Button pohrani;
    private Context context;
    DbHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_projekt, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nazProjekta = (EditText) view.findViewById(R.id.NazivUnos);
        opisProjekta = (EditText) view.findViewById(R.id.OpisUnos);
        datPocetka = (DatePicker) view.findViewById(R.id.DatPocetkaUnos);
        datZavrsetka = (DatePicker) view.findViewById(R.id.DatZavrsetkaUnos);

        pohrani = (Button) view.findViewById(R.id.PohraniGumb);

        view.findViewById(R.id.PohraniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nazProjekta = nazProjekta.getText().toString();
                String _opisProjekta = opisProjekta.getText().toString();
                Date datumPocetka = parseDatePicker(datPocetka);
                Date datumZavrsetka = parseDatePicker(datZavrsetka);


                Projekt noviProjekt = new Projekt(_nazProjekta,
                        _opisProjekta, datumPocetka, datumZavrsetka);

                db = new DbHandler(context);
                db.addProjekt(noviProjekt);

                Toast.makeText(context, "Dodan novi projekt" + _nazProjekta,Toast.LENGTH_LONG).show();

                NavHostFragment.findNavController(ProjektFragment.this)
                        .navigate(R.id.action_ProjektFragment_to_FirstFragment);



            }

        });



        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProjektFragment.this)
                        .navigate(R.id.action_ProjektFragment_to_FirstFragment);
            }
        });
    }

    private Date parseDatePicker(DatePicker datePicker){
        String datumDan = String.valueOf(datePicker.getDayOfMonth());
        String datumMjesec = String.valueOf(datePicker.getMonth() + 1);
        String datumGodina = String.valueOf(datePicker.getYear());

        Date datum = new Date();

        try {
            datum=new SimpleDateFormat("dd/MM/yyyy").parse(String.format("%s/%s/%s",
                    datumDan, datumMjesec, datumGodina));


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return datum;
    }
}
