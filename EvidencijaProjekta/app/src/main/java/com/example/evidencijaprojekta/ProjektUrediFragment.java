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

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProjektUrediFragment extends Fragment {
    DbHandler readDb;
    private Context context;
    ArrayList<String> listaProjekata;
    ListView listView;
    Button povratak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_projekt_uredi, container, false);
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
                NavHostFragment.findNavController(ProjektUrediFragment.this)
                        .navigate(R.id.action_ProjektUrediFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.DodajNoviProjekt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProjektUrediFragment.this)
                        .navigate(R.id.action_ProjektUrediFragment_to_ProjektFragment);
            }
        });


    }

}
