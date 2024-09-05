package com.boerse.controllers;

import com.boerse.models.Kunde;
import com.boerse.services.KundeService;

import java.util.Scanner;

public class KundeController {

    private final KundeService kundeService;
    private Kunde loggedInKunde;

    public KundeController() {
        this.kundeService = new KundeService();
    }

    // Methode zur Anzeige des Login-Menüs
    public void showLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Login ===");
        System.out.print("Kunden ID: ");
        int kundenId = scanner.nextInt();
        System.out.print("Passwort: ");
        String password = scanner.next();

        // Login-Versuch
        Kunde kunde = kundeService.login(kundenId, password);
        if (kunde != null) {
            loggedInKunde = kunde;
            System.out.println("Login erfolgreich. Willkommen, " + kunde.getName() + "!");
            showMainMenu(); // Weiterleitung zum Hauptmenü nach erfolgreichem Login
        } else {
            System.out.println("Ungültige Anmeldedaten.");
        }
    }

    // Methode zur Anzeige des Hauptmenüs für eingeloggte Kunden
    public void showMainMenu() {
        if (loggedInKunde == null) {
            System.out.println("Sie sind nicht eingeloggt.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Hauptmenü ===");
            System.out.println("1. Kundendaten anzeigen");
            System.out.println("2. Passwort ändern");
            System.out.println("0. Logout");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    showCustomerDetails();
                    break;
                case 2:
                    changePassword();
                    break;
                case 0:
                    logout();
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);
    }

    // Methode zur Anzeige der Kundendaten
    public void showCustomerDetails() {
        if (loggedInKunde != null) {
            System.out.println("=== Kundendaten ===");
            System.out.println("Kunden ID: " + loggedInKunde.getKundenId());
            System.out.println("Name: " + loggedInKunde.getName());
            System.out.println("Guthaben: " + loggedInKunde.getGuthaben());
            System.out.println("Kredit: " + loggedInKunde.getKredit());
            System.out.println("Admin: " + (loggedInKunde.isAdmin() ? "Ja" : "Nein"));
        } else {
            System.out.println("Sie sind nicht eingeloggt.");
        }
    }

    // Methode zum Ändern des Passworts
    public void changePassword() {
        if (loggedInKunde == null) {
            System.out.println("Sie sind nicht eingeloggt.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Neues Passwort eingeben: ");
        String newPassword = scanner.next();

        if (kundeService.changePassword(loggedInKunde.getKundenId(), newPassword)) {
            System.out.println("Passwort erfolgreich geändert.");
        } else {
            System.out.println("Fehler beim Ändern des Passworts.");
        }
    }

    // Methode zum Ausloggen
    public void logout() {
        loggedInKunde = null;
        System.out.println("Sie wurden ausgeloggt.");
    }
}
