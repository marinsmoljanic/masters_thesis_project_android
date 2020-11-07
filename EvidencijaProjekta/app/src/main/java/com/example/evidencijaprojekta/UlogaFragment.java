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

public class UlogaFragment extends Fragment {
    EditText nazUloge;
    Button pohrani;
    private Context context;
    DbHandler db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_uloga, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nazUloge = (EditText) view.findViewById(R.id.NazivUlogeUnos);

        pohrani = (Button) view.findViewById(R.id.PohraniGumb);

        view.findViewById(R.id.PohraniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nazUloge = nazUloge.getText().toString();

                Uloga novaUloga = new Uloga(_nazUloge);

                db = new DbHandler(context);
                db.addUloga(novaUloga);

                Toast.makeText(context, "Dodana nova uloga" + _nazUloge, Toast.LENGTH_LONG).show();

                NavHostFragment.findNavController(UlogaFragment.this)
                        .navigate(R.id.action_UlogaFragment_to_FirstFragment);

            }

        });


        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UlogaFragment.this)
                        .navigate(R.id.action_UlogaFragment_to_FirstFragment);
            }
        });
    }
}