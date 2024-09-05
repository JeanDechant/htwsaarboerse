package com.boerse.models;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private int portfolioId;           // Eindeutige ID des Portfolios
    private int kundenId;              // Die ID des Kunden, dem das Portfolio gehört
    private Map<Aktie, Integer> aktien; // Eine Map der Aktien und deren Anzahl im Portfolio

    // Konstruktor
    public Portfolio(int portfolioId, int kundenId) {
        this.portfolioId = portfolioId;
        this.kundenId = kundenId;
        this.aktien = new HashMap<>();
    }

    // Getter und Setter
    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getKundenId() {
        return kundenId;
    }

    public void setKundenId(int kundenId) {
        this.kundenId = kundenId;
    }

    public Map<Aktie, Integer> getAktien() {
        return aktien;
    }

    public void setAktien(Map<Aktie, Integer> aktien) {
        this.aktien = aktien;
    }

    // Methode zum Hinzufügen von Aktien zum Portfolio
    public void addAktie(Aktie aktie, int anzahl) {
        this.aktien.put(aktie, this.aktien.getOrDefault(aktie, 0) + anzahl);
    }

    // Methode zum Entfernen von Aktien aus dem Portfolio
    public void removeAktie(Aktie aktie, int anzahl) {
        if (this.aktien.containsKey(aktie)) {
            int currentAnzahl = this.aktien.get(aktie);
            if (currentAnzahl > anzahl) {
                this.aktien.put(aktie, currentAnzahl - anzahl);
            } else {
                this.aktien.remove(aktie); // Entfernt die Aktie vollständig, wenn weniger oder gleiche Anzahl vorhanden ist
            }
        }
    }

    // Berechne den Gesamtwert des Portfolios
    public double getTotalPortfolioValue() {
        return this.aktien.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", kundenId=" + kundenId +
                ", aktien=" + aktien +
                '}';
    }
}
