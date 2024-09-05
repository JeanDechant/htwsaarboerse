package com.boerse.models;

import java.util.Date;

public class Transaktion {
    private int transaktionId;      // Eindeutige ID der Transaktion
    private int kundenId;           // ID des Kunden, der die Transaktion durchführt
    private int aktieId;            // ID der Aktie, die gekauft/verkauft wird
    private int anzahl;             // Anzahl der Aktien, die gehandelt werden
    private double preis;           // Preis pro Aktie während der Transaktion
    private Date datum;             // Datum der Transaktion
    private String typ;             // Typ der Transaktion (Kauf, Verkauf)

    // Konstruktor
    public Transaktion(int transaktionId, int kundenId, int aktieId, int anzahl, double preis, Date datum, String typ) {
        this.transaktionId = transaktionId;
        this.kundenId = kundenId;
        this.aktieId = aktieId;
        this.anzahl = anzahl;
        this.preis = preis;
        this.datum = datum;
        this.typ = typ;
    }

    // Getter und Setter
    public int getTransaktionId() {
        return transaktionId;
    }

    public void setTransaktionId(int transaktionId) {
        this.transaktionId = transaktionId;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public int getAktieId() {
        return aktieId;
    }

    public void setAktieId(int aktieId) {
        this.aktieId = aktieId;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "Transaktion{" +
                "transaktionId=" + transaktionId +
                ", kundenId=" + kundenId +
                ", aktieId=" + aktieId +
                ", anzahl=" + anzahl +
                ", preis=" + preis +
                ", datum=" + datum +
                ", typ='" + typ + '\'' +
                '}';
    }
}
