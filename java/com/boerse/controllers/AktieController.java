package com.boerse.controllers;

import com.boerse.models.Aktie;
import com.boerse.services.AktieService;

import java.util.List;
import java.util.Scanner;

public class AktieController {

    private final AktieService aktieService;

    public AktieController() {
        this.aktieService = new AktieService();
    }

    // Methode zur Anzeige des Aktienmenüs
    public void showAktienMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Aktienmenü ===");
            System.out.println("1. Alle Aktien anzeigen");
            System.out.println("2. Aktie kaufen");
            System.out.println("3. Aktie verkaufen");
            System.out.println("4. Aktie verwalten (nur für Admins)");
            System.out.println("0. Zurück");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayAllAktien();
                    break;
                case 2:
                    buyAktie();
                    break;
                case 3:
                    sellAktie();
                    break;
                case 4:
                    manageAktie();
                    break;
                case 0:
                    System.out.println("Zurück zum Hauptmenü.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);
    }

    // Methode zur Anzeige aller Aktien
    public void displayAllAktien() {
        List<Aktie> aktienListe = aktieService.getAllAktien();
        System.out.println("=== Verfügbare Aktien ===");
        for (Aktie aktie : aktienListe) {
            System.out.println(aktie);
        }
    }

    // Methode zum Kaufen von Aktien
    public void buyAktie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Anzahl der Aktien eingeben: ");
        int anzahl = scanner.nextInt();

        Aktie aktie = aktieService.getAktieById(aktieId);
        if (aktie != null) {
            System.out.println("Aktie " + aktie.getName() + " für " + aktie.getPreis() + " pro Stück gekauft.");
            // Weitere Logik für den Kauf der Aktie...
        } else {
            System.out.println("Aktie nicht gefunden.");
        }
    }

    // Methode zum Verkaufen von Aktien
    public void sellAktie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Anzahl der Aktien eingeben: ");
        int anzahl = scanner.nextInt();

        Aktie aktie = aktieService.getAktieById(aktieId);
        if (aktie != null) {
            System.out.println("Aktie " + aktie.getName() + " für " + aktie.getPreis() + " pro Stück verkauft.");
            // Weitere Logik für den Verkauf der Aktie...
        } else {
            System.out.println("Aktie nicht gefunden.");
        }
    }

    // Methode zur Verwaltung von Aktien (nur für Admins)
    public void manageAktie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Aktienverwaltung ===");
        System.out.println("1. Aktie hinzufügen");
        System.out.println("2. Aktienpreis ändern");
        System.out.println("3. Aktie löschen");
        System.out.print("Wählen Sie eine Option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addAktie();
                break;
            case 2:
                updateAktienPreis();
                break;
            case 3:
                deleteAktie();
                break;
            default:
                System.out.println("Ungültige Option.");
        }
    }

    // Methode zum Hinzufügen einer neuen Aktie
    public void addAktie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktienname eingeben: ");
        String name = scanner.next();
        System.out.print("Aktienkürzel eingeben: ");
        String kuerzel = scanner.next();
        System.out.print("Firmen ID eingeben: ");
        int companyId = scanner.nextInt();
        System.out.print("Aktienpreis eingeben: ");
        double preis = scanner.nextDouble();

        Aktie aktie = new Aktie(0, name, kuerzel, companyId, preis, new java.util.Date());
        if (aktieService.addAktie(aktie)) {
            System.out.println("Aktie erfolgreich hinzugefügt.");
        } else {
            System.out.println("Fehler beim Hinzufügen der Aktie.");
        }
    }

    // Methode zum Ändern des Aktienpreises
    public void updateAktienPreis() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Neuen Preis eingeben: ");
        double neuerPreis = scanner.nextDouble();

        if (aktieService.updateAktienPreis(aktieId, neuerPreis)) {
            System.out.println("Preis der Aktie erfolgreich geändert.");
        } else {
            System.out.println("Fehler beim Ändern des Preises.");
        }
    }

    // Methode zum Löschen einer Aktie
    public void deleteAktie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();

        if (aktieService.deleteAktie(aktieId)) {
            System.out.println("Aktie erfolgreich gelöscht.");
        } else {
            System.out.println("Fehler beim Löschen der Aktie.");
        }
    }
}
