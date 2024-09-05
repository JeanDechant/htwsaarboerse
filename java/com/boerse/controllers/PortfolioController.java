package com.boerse.controllers;

import com.boerse.models.Aktie;
import com.boerse.services.AktieService;
import com.boerse.services.PortfolioService;

import java.util.Scanner;

public class PortfolioController {

    private final PortfolioService portfolioService;
    private final AktieService aktieService;

    public PortfolioController() {
        this.portfolioService = new PortfolioService();
        this.aktieService = new AktieService();
    }

    // Methode zur Anzeige des Portfolio-Menüs
    public void showPortfolioMenu(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Portfolio-Menü ===");
            System.out.println("1. Mein Portfolio anzeigen");
            System.out.println("2. Aktien zu Portfolio hinzufügen");
            System.out.println("3. Aktien aus Portfolio entfernen");
            System.out.println("4. Portfoliowert anzeigen");
            System.out.println("0. Zurück");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    showPortfolio(kundenId);
                    break;
                case 2:
                    addAktieToPortfolio(kundenId);
                    break;
                case 3:
                    removeAktieFromPortfolio(kundenId);
                    break;
                case 4:
                    showPortfolioValue(kundenId);
                    break;
                case 0:
                    System.out.println("Zurück zum Hauptmenü.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);
    }

    // Methode zur Anzeige des Portfolios
    public void showPortfolio(int kundenId) {
        var portfolios = portfolioService.getPortfoliosByKundenId(kundenId);
        for (var portfolio : portfolios) {
            System.out.println(portfolio);
        }
    }

    // Methode zum Hinzufügen von Aktien zu einem Portfolio
    public void addAktieToPortfolio(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Portfolio ID eingeben: ");
        int portfolioId = scanner.nextInt();
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Anzahl der Aktien eingeben: ");
        int anzahl = scanner.nextInt();

        Aktie aktie = aktieService.getAktieById(aktieId);
        if (aktie != null) {
            if (portfolioService.addAktieToPortfolio(portfolioId, aktie, anzahl)) {
                System.out.println("Aktien erfolgreich hinzugefügt.");
            } else {
                System.out.println("Fehler beim Hinzufügen der Aktien.");
            }
        } else {
            System.out.println("Aktie nicht gefunden.");
        }
    }

    // Methode zum Entfernen von Aktien aus einem Portfolio
    public void removeAktieFromPortfolio(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Portfolio ID eingeben: ");
        int portfolioId = scanner.nextInt();
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Anzahl der zu entfernenden Aktien eingeben: ");
        int anzahl = scanner.nextInt();

        Aktie aktie = aktieService.getAktieById(aktieId);
        if (aktie != null) {
            if (portfolioService.removeAktieFromPortfolio(portfolioId, aktie, anzahl)) {
                System.out.println("Aktien erfolgreich entfernt.");
            } else {
                System.out.println("Fehler beim Entfernen der Aktien.");
            }
        } else {
            System.out.println("Aktie nicht gefunden.");
        }
    }

    // Methode zum Anzeigen des Gesamtwerts eines Portfolios
    public void showPortfolioValue(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Portfolio ID eingeben: ");
        int portfolioId = scanner.nextInt();

        double value = portfolioService.getPortfolioValue(portfolioId);
        System.out.println("Der Gesamtwert des Portfolios beträgt: " + value);
    }
}
