package com.example.evidencijaprojekta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;


public class UlogaOsobeUrediFragment extends Fragment {
    DbHandler readDb;
    private Context context;
    ArrayList<String> listaUlogaOsoba;
    ListView listView;
    Button povratak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_ulogaosobe_uredi, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //ListView listview = (ListView) view.findViewById(R.id.ListaProjekata);

        //ProjektInfoList projektInfoList = new ProjektInfoList(context, view);
        //listaProjekata = projektInfoList.getList();

        //ListAdapter adapter=new ListAdapter(context,
        //        R.layout.fragment_projekt_redak,
        //        R.id.txt,
        //        listaProjekata);
        // Bind data to the ListView
        //listview.setAdapter(adapter);


        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UlogaOsobeUrediFragment.this)
                        .navigate(R.id.action_UlogaUrediFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.DodajNovuUloguOsobe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UlogaOsobeUrediFragment.this)
                        .navigate(R.id.action_UlogaOsobeUrediFragment_to_UlogaOsobeFragment);
            }
        });


    }

}
