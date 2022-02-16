package com.example.gestorefile;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GestoreFile {
    String nomeFile;
    Context c;
    StringBuilder sb;

    //COSTRUTTORE
    public GestoreFile(String nomeFile, Context c){
        this.nomeFile = nomeFile;
        this.c = c;
        sb = new StringBuilder();
    }

    //METODO LETTURA FILE
    public String leggiFile(String nomeFile, Context c){
        String str = "";

        try {
            //SERVE PER LEGGERE    c = contesto
            // APERTURA DEL FILE
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            //CICLO PER LEGGERE RIGA PER RIGA
            //ACCODO OGNI RIGA ALLA STRINGA
            String inputString;
            while ((inputString = inputReader.readLine())!= null){
                sb.append(inputString + "\n");
            }
        }
        catch (FileNotFoundException e){
            Log.e(TAG, "ERRORE FILE NON TROVATO");
            return "FNF";
        } catch (IOException e){
            return "IO ERROR";
        }

        //OUTPUT FINALE
        return sb.toString();
    }

    //METODO SCRITTURA FILE
    public String scriviFile(String nomeFile, Context c){
        FileOutputStream fileO;
        String esito = "";

        String tetodascrivere = "Questo è il testo del file";

        try{
            fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileO.write(tetodascrivere.getBytes());
        }

        catch (FileNotFoundException e){
            esito = "ATTENZIONE ERRORE IN APERTURA";
        }

        catch (IOException e){
            esito = "ERRORE IN SCRITTURA";
        }

        return esito;
    }
}
