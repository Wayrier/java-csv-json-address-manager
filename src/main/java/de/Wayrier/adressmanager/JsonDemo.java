package de.Wayrier.adressmanager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String pfad = "personen.json";

        //  Liste mit Beispieldaten erstellen
        ArrayList<CSVEntry> liste = new ArrayList<>();
        liste.add(new CSVEntry("Mohammed", "Afana", "m.afana@test.de"));
        liste.add(new CSVEntry("Anna", "Müller", "anna.mueller@test.de"));

        //  JSON schreiben
        try (FileWriter writer = new FileWriter(pfad)) {
            gson.toJson(liste, writer);
            System.out.println("JSON gespeichert in: " + pfad);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  JSON wieder einlesen
        try (FileReader reader = new FileReader(pfad)) {
            Type listType = new TypeToken<ArrayList<CSVEntry>>() {}.getType();
            ArrayList<CSVEntry> geladeneListe = gson.fromJson(reader, listType);

            System.out.println("Aus JSON gelesen:");
            for (CSVEntry e : geladeneListe) {
                System.out.println(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
