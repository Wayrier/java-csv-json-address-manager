package de.Wayrier.adressmanager;

public class CSVEntry {
    private String vorname;
    private String nachname;
    private String email;

    public CSVEntry() {}

    public CSVEntry(String vorname, String nachname, String email) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toCSVFormat() {
        return String.join(",", vorname, nachname, email);
    }

    @Override
    public String toString() {
        return vorname + ", " + nachname + ", " + email;
    }
}
