package com.example.evidencijaprojekta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //public void onClick(View view) {
        //        Snackbar.make(view, "Poruka", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void deleteOsobaClick(View view){
        Button bt=(Button)view;
        String osobaId = (String) view.getTag();
        DbHandler db = new DbHandler(this);
        int intOsobaId  = Integer.valueOf(osobaId);
        Toast.makeText(this, "Obrisana osoba: "+ osobaId,Toast.LENGTH_LONG).show();
        db.deleteOsoba(intOsobaId);

        //Fragment frg = null;
        //frg = getSupportFragmentManager().findFragmentByTag((String) view.getTag());
        //final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //ft.detach(frg);
        //ft.attach(frg);
        //ft.commit();
    }



    public void deleteProjektClick(View view){
        Button bt=(Button)view;
        Toast.makeText(this, "Button "+ bt.getText().toString(),Toast.LENGTH_LONG).show();
    }

    public void deleteUlogaClick(View view){
        Button bt=(Button)view;
        Toast.makeText(this, "Button "+ bt.getText().toString(),Toast.LENGTH_LONG).show();
    }
}