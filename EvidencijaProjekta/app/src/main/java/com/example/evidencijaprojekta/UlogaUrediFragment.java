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


public class UlogaUrediFragment extends Fragment {
    DbHandler readDb;
    private Context context;
    ArrayList<String> listaUloga;
    ListView listView;
    Button povratak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_uloga_uredi, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ListView listview = (ListView) view.findViewById(R.id.ListaUloga);

        UlogaInfoList ulogaInfoList = new UlogaInfoList(context, view);
        listaUloga = ulogaInfoList.getList();

        UlogaListAdapter adapter=new UlogaListAdapter(context,
                R.layout.fragment_uloga_redak,
                R.id.txt,
                listaUloga);
        // Bind data to the ListView
         listview.setAdapter(adapter);


        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UlogaUrediFragment.this)
                        .navigate(R.id.action_UlogaUrediFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.DodajNovuUlogu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UlogaUrediFragment.this)
                        .navigate(R.id.action_UlogaUrediFragment_to_UlogaFragment);
            }
        });


    }

}
