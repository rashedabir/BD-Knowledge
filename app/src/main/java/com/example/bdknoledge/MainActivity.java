package com.example.bdknoledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    String[] district = {"Select","Dhaka", "Comilla", "Cox's Bazar"};

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, district);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Fragment myFragment;
        if(text.equals("Dhaka")){
            myFragment = new DhakaFragment();
        }
        else if(text.equals("Comilla")){
            myFragment = new comillaFragment();
        }
        else if(text.equals("Cox's Bazar")){
            myFragment = new coxBazar();
        }
        else {
            myFragment = new BlankFragment();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.myFragment, myFragment);
        ft.commit();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}