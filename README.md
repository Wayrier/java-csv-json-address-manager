# CSV & JSON Address Manager (Java)

Kleine Java-Übungsanwendung zum Verwalten einer Adressliste mit CSV- und JSON-Unterstützung.

## Features

- CSV-Datei einlesen (Adressliste)
- Adressen anzeigen
- Neue Adresse hinzufügen
- Export der Adressen als JSON
- Import der Adressen aus einer JSON-Datei
- Einfache GUI mit `JOptionPane`

## Technologien

- Java (SE)
- Swing (`JOptionPane`)
- Gson (für JSON)

## Projektstruktur

- `CSVEntry` – Modellklasse für einen Adressdatensatz (Vorname, Nachname, E-Mail)
- `CSVManager` – Logik für:
  - CSV lesen/schreiben
  - JSON-Export (`exportToJson`)
  - JSON-Import (`importFromJson`)
- `CSVApp` – Hauptprogramm mit Menü (CSV/JSON-Verwaltung)

## Ausführen

- Projekt in IntelliJ öffnen
- Sicherstellen, dass `gson` als Library eingebunden ist
- `CSVApp` als `main`-Klasse starten
