package com.boerse.controllers;

import com.boerse.models.*;
import com.boerse.services.BoerseService;

import java.sql.SQLException;
import java.util.List;

public class BoerseController {

    private BoerseService boerseService;

    public BoerseController() {
        this.boerseService = new BoerseService();
    }
	//Annie are you okay? Are you okay Annie?


    // Methode zum Hinzufügen eines neuen Kunden
    public void addKunde(Kunde kunde) {
        try {
            boerseService.createKunde(kunde);
            System.out.println("Kunde erfolgreich hinzugefügt!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Hinzufügen des Kunden: " + e.getMessage());
        }
    }

    // Methode zum Abrufen eines Kunden nach ID
    public void showKunde(int kundenId) {
        try {
            Kunde kunde = boerseService.getKundeById(kundenId);
            if (kunde != null) {
                System.out.println("Kunde: " + kunde);
            } else {
                System.out.println("Kein Kunde mit der ID gefunden: " + kundenId);
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Abrufen des Kunden: " + e.getMessage());
        }
    }

    // Methode zum Hinzufügen einer neuen Transaktion
    public void addTransaktion(Transaktion transaktion) {
        try {
            boerseService.createTransaktion(transaktion);
            System.out.println("Transaktion erfolgreich hinzugefügt!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Hinzufügen der Transaktion: " + e.getMessage());
        }
    }

    // Methode zum Abrufen aller Transaktionen eines Kunden
    public void showTransaktionen(int kundenId) {
        try {
            List<Transaktion> transaktionen = boerseService.getTransaktionenByKundenId(kundenId);
            if (!transaktionen.isEmpty()) {
                transaktionen.forEach(transaktion -> System.out.println("Transaktion: " + transaktion));
            } else {
                System.out.println("Keine Transaktionen für Kunden-ID: " + kundenId);
            }
        } catch (SQLException e) {
            System.err.println("Fehler beim Abrufen der Transaktionen: " + e.getMessage());
        }
    }
}
