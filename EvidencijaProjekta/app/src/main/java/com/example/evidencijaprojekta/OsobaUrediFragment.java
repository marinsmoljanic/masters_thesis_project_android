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


public class OsobaUrediFragment extends Fragment {
    DbHandler readDb;
    private Context context;
    ArrayList<String> listaOsoba;
    ListView listView;
    Button povratak;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = this.getActivity();
        return inflater.inflate(R.layout.fragment_osoba_uredi, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Naknadno: SA GUMBOM

        ListView lstview = (ListView) view.findViewById(R.id.ListaOsoba);
        //lstview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        //        Toast.makeText(context, "An item of the ListView is clicked.", Toast.LENGTH_LONG).show();
        //    }
        //});

        OsobaInfoList osobaInfoList = new OsobaInfoList(context, view);
        listaOsoba = osobaInfoList.getList();

        ListAdapter adapter=new ListAdapter(context,
                R.layout.fragment_osoba_redak,
                R.id.txt,
                listaOsoba);
        // Bind data to the ListView
        lstview.setAdapter(adapter);


        view.findViewById(R.id.PovratniGumb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OsobaUrediFragment.this)
                        .navigate(R.id.action_OsobaUrediFragment_to_FirstFragment);
            }
        });

        view.findViewById(R.id.DodajNovuOsobu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OsobaUrediFragment.this)
                        .navigate(R.id.action_OsobaUrediFragment_to_OsobaFragment);
            }
        });


        //view.findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        NavHostFragment.findNavController(OsobaUrediFragment.this)
        //                .navigate(R.id.action_OsobaUrediFragment_to_FirstFragment);
        //    }
        //});

    }

}
