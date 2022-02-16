package com.example.gestorefile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button leggi;
    Button scrivi;
    GestoreFile gest;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leggi = (Button) findViewById(R.id.leggi);
        scrivi = (Button) findViewById(R.id.scrivi);
        textView = (TextView) findViewById(R.id.textView);

        //LETTURA
        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String risultato = gest.leggiFile("prova.txt", getApplicationContext());
                textView.setText(risultato);
            }
        });

        //SCRITTURA
        scrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito = gest.scriviFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_SHORT).show();
            }
        });

    }
}