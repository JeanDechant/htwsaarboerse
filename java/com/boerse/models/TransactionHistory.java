package com.boerse.models;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private int kundenId;                      // Kunden-ID für den die Historie gespeichert wird
    private List<Transaktion> transaktionen;    // Liste der Transaktionen des Kunden

    // Konstruktor
    public TransactionHistory(int kundenId) {
        this.kundenId = kundenId;
        this.transaktionen = new ArrayList<>();
    }

    // Getter und Setter
    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public List<Transaktion> getTransaktionen() {
        return transaktionen;
    }

    public void setTransaktionen(List<Transaktion> transaktionen) {
        this.transaktionen = transaktionen;
    }

    // Methode um eine Transaktion hinzuzufügen
    public void addTransaktion(Transaktion transaktion) {
        this.transaktionen.add(transaktion);
    }

    // Methode um die Transaktionshistorie zu durchsuchen
    public Transaktion findTransaktionById(int transaktionId) {
        for (Transaktion t : transaktionen) {
            if (t.getTransaktionId() == transaktionId) {
                return t;
            }
        }
        return null;
    }

    // Methode um alle Transaktionen anzuzeigen
    public void displayAllTransaktionen() {
        for (Transaktion t : transaktionen) {
            System.out.println(t);
        }
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "kundenId=" + kundenId +
                ", transaktionen=" + transaktionen +
                '}';
    }
}
