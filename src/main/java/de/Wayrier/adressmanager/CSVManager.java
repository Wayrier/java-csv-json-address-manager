package de.Wayrier.adressmanager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CSVManager {
    private File csvFile;
    private ArrayList<CSVEntry> eintraege;

    public CSVManager(String pfad) {
        this.csvFile = new File(pfad);
        this.eintraege = new ArrayList<>();
    }

    public File getCsvFile() {
        return csvFile;
    }

    public void setCsvFile(File csvFile) {
        this.csvFile = csvFile;
    }

    public ArrayList<CSVEntry> getEintraege() {
        return eintraege;
    }

    public void setEintraege(ArrayList<CSVEntry> eintraege) {
        this.eintraege = eintraege;
    }

    public boolean leseDatei() {
        if (!csvFile.exists() || !csvFile.canRead()) {
            JOptionPane.showMessageDialog(null, "Datei nicht gefunden oder nicht lesbar!");
            return false;
        }
        eintraege.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String zeile;
            br.readLine();
            while ((zeile = br.readLine()) != null) {
                if (zeile.trim().isEmpty()) {
                    continue;
                }
                String[] split = zeile.split(",");
                if (split.length < 3) {
                    System.out.println("Ungültige Zeile übersprungen: " + zeile);
                    continue;
                }
                String vorname = split[0].trim();
                String nachname = split[1].trim();
                String email = split[2].trim();
                eintraege.add(new CSVEntry(vorname, nachname, email));
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Lesen: " + e.getMessage());
            return false;
        }
    }

    public boolean hinzufuegeEintrag(CSVEntry neuerEintrag) {
        eintraege.add(neuerEintrag);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            writer.write(neuerEintrag.toCSVFormat());
            writer.newLine();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Schreiben: " + e.getMessage());
            return false;
        }
    }

    public String zeigeEintraege() {
        StringBuilder builder = new StringBuilder();
        for (CSVEntry e : eintraege) {
            builder.append(e.toCSVFormat()).append(System.lineSeparator());
        }
        return builder.toString();
    }
    //  CSV-Liste → JSON-Datei
    public boolean exportToJson(String jsonPfad) {
        Gson gson = new Gson();
        File jsonFile = new File(jsonPfad);

        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(eintraege, writer);
            System.out.println("Export nach JSON erfolgreich: " + jsonFile.getAbsolutePath());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //  JSON-Datei → Liste (ersetzt aktuelle Einträge)
    public boolean importFromJson(String jsonPfad) {
        Gson gson = new Gson();
        File jsonFile = new File(jsonPfad);

        if (!jsonFile.exists() || !jsonFile.canRead()) {
            System.out.println("JSON-Datei nicht gefunden oder nicht lesbar.");
            return false;
        }

        try (FileReader reader = new FileReader(jsonFile)) {
            Type listType = new TypeToken<ArrayList<CSVEntry>>() {}.getType();
            ArrayList<CSVEntry> ausJson = gson.fromJson(reader, listType);

            if (ausJson != null) {
                eintraege.clear();
                eintraege.addAll(ausJson);
                System.out.println("Import aus JSON erfolgreich. Einträge: " + eintraege.size());
                return true;
            } else {
                System.out.println("JSON-Datei war leer oder ungültig.");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean loescheEintrag(int index) {
        if (index >= 0 && index < eintraege.size()) {
            eintraege.remove(index);
            return true;
        }
        return false;
    }
    public boolean aktualisiereEintrag(int index, String neuerVorname, String neuerNachname, String neueEmail) {
        if (index >= 0 && index < eintraege.size()) {
            CSVEntry eintrag = eintraege.get(index);
            eintrag.setVorname(neuerVorname);
            eintrag.setNachname(neuerNachname);
            eintrag.setEmail(neueEmail);
            return true;
        }
        return false;
    }


}