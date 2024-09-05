package com.boerse.models;

import java.util.Date;

public class Aktie {
    private int aktieId;         // Eindeutige ID der Aktie
    private String name;         // Name der Aktie
    private String kuerzel;      // Börsenkürzel der Aktie
    private int companyId;       // Zugehörige Firmen-ID
    private double preis;        // Aktueller Preis der Aktie
    private Date erstellungsdatum;  // Datum, an dem die Aktie erstellt wurde

    // Konstruktor
    public Aktie(int aktieId, String name, String kuerzel, int companyId, double preis, Date erstellungsdatum) {
        this.aktieId = aktieId;
        this.name = name;
        this.kuerzel = kuerzel;
        this.companyId = companyId;
        this.preis = preis;
        this.erstellungsdatum = erstellungsdatum;
    }

    // Getter und Setter
    public int getAktieId() {
        return aktieId;
    }

    public void setAktieId(int aktieId) {
        this.aktieId = aktieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String kuerzel) {
        this.kuerzel = kuerzel;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Date getErstellungsdatum() {
        return erstellungsdatum;
    }

    public void setErstellungsdatum(Date erstellungsdatum) {
        this.erstellungsdatum = erstellungsdatum;
    }

    @Override
    public String toString() {
        return "Aktie{" +
                "aktieId=" + aktieId +
                ", name='" + name + '\'' +
                ", kuerzel='" + kuerzel + '\'' +
                ", companyId=" + companyId +
                ", preis=" + preis +
                ", erstellungsdatum=" + erstellungsdatum +
                '}';
    }
}
