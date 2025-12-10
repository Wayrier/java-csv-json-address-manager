package de.Wayrier.adressmanager;

import com.google.gson.Gson;

import javax.swing.*;
import java.io.FileWriter;

public class CSVApp {
    public static void main(String[] args) {
        String pfad = JOptionPane.showInputDialog(null, "Geben Sie den absoluten Dateipfad zur CSV-Datei ein:");

        if (pfad == null || pfad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kein Pfad angegeben. Programm wird beendet.");
            return;
        }

        CSVManager csv = new CSVManager(pfad);

        if (!csv.leseDatei()) {
            JOptionPane.showMessageDialog(null, "Fehler beim Einlesen der CSV-Datei.");
            return;
        }

        JOptionPane.showMessageDialog(null, "Vorhandene Einträge:\n" + csv.zeigeEintraege());

        JOptionPane.showMessageDialog(null, "Geben Sie einen neuen Eintrag ein.");

        String vorname = JOptionPane.showInputDialog("Vorname:");
        String nachname = JOptionPane.showInputDialog("Nachname:");
        String email = JOptionPane.showInputDialog("Email:");

        if (vorname == null || nachname == null || email == null) {
            JOptionPane.showMessageDialog(null, "Eingabe abgebrochen. Programm endet.");
            return;
        }

        CSVEntry neuerEintrag = new CSVEntry(vorname, nachname, email);

        if (csv.hinzufuegeEintrag(neuerEintrag)) {
            JOptionPane.showMessageDialog(null, "Eintrag wurde erfolgreich hinzugefügt.");
        } else {
            JOptionPane.showMessageDialog(null, "Fehler beim Hinzufügen des Eintrags.");
            return;
        }

        csv.leseDatei();
        JOptionPane.showMessageDialog(null, "Aktualisierte Adressliste:\n" + csv.zeigeEintraege());

    //C:\Users\Student\OneDrive - GFN GmbH (EDU)\Desktop\Java\Projekte\Uebungen\src\woche3\tag3\csv\csv.csv




    }

}
/*

package Projekte.Uebungen.src.woche3.tag3.csv;

import javax.swing.*;

public class CSVApp {
    public static void main(String[] args) {
        String pfad = JOptionPane.showInputDialog(null,
                "Geben Sie den absoluten Dateipfad zur CSV-Datei ein:");

        if (pfad == null || pfad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kein Pfad angegeben. Programm wird beendet.");
            return;
        }

        CSVManager csv = new CSVManager(pfad);

        if (!csv.leseDatei()) {
            JOptionPane.showMessageDialog(null, "Fehler beim Einlesen der CSV-Datei.");
            return;
        }

        int option;

        do {
            String input = JOptionPane.showInputDialog(
                    """
                    CSV / JSON Verwaltung

                    1 - Einträge anzeigen
                    2 - neuen Eintrag hinzufügen
                    3 - Einträge nach JSON exportieren
                    4 - Einträge aus JSON importieren
                    0 - Beenden

                    Bitte wählen:
                    """);

            if (input == null) { // Abbrechen = Beenden
                return;
            }

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Bitte eine gültige Zahl eingeben.");
                option = -1;
            }

            switch (option) {
                case 1 -> {
                    JOptionPane.showMessageDialog(null,
                            "Aktuelle Adressliste:\n" + csv.zeigeEintraege());
                }
                case 2 -> {
                    String vorname = JOptionPane.showInputDialog("Vorname:");
                    String nachname = JOptionPane.showInputDialog("Nachname:");
                    String email = JOptionPane.showInputDialog("Email:");

                    if (vorname == null || nachname == null || email == null) {
                        JOptionPane.showMessageDialog(null, "Eingabe abgebrochen.");
                        break;
                    }

                    CSVEntry neuerEintrag = new CSVEntry(vorname, nachname, email);

                    if (csv.hinzufuegeEintrag(neuerEintrag)) {
                        // CSV neu einlesen, damit Liste aktuell ist
                        csv.leseDatei();
                        JOptionPane.showMessageDialog(null, "Eintrag wurde erfolgreich hinzugefügt.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fehler beim Hinzufügen des Eintrags.");
                    }
                }
                case 3 -> {
                    String jsonPfad = JOptionPane.showInputDialog(
                            "Pfad für die JSON-Datei (z.B. C:\\\\temp\\\\adressen.json):");
                    if (jsonPfad == null || jsonPfad.trim().isEmpty()) break;

                    if (csv.exportToJson(jsonPfad)) {
                        JOptionPane.showMessageDialog(null,
                                "Export nach JSON war erfolgreich.\nDatei: " + jsonPfad);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fehler beim Export nach JSON.");
                    }
                }
                case 4 -> {
                    String jsonPfad = JOptionPane.showInputDialog(
                            "Pfad der JSON-Datei zum Importieren:");
                    if (jsonPfad == null || jsonPfad.trim().isEmpty()) break;

                    if (csv.importFromJson(jsonPfad)) {
                        JOptionPane.showMessageDialog(null,
                                "Import aus JSON war erfolgreich.\nAktuelle Liste:\n" + csv.zeigeEintraege());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fehler beim Import aus JSON.");
                    }
                }
                case 0 -> JOptionPane.showMessageDialog(null, "Programm wird beendet.");
                default -> JOptionPane.showMessageDialog(null, "Ungültige Auswahl.");
            }

        } while (option != 0);
    }
}

*/