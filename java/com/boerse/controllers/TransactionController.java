package com.boerse.controllers;

import com.boerse.models.Transaktion;
import com.boerse.services.TransactionService;

import java.util.List;
import java.util.Scanner;

public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    // Methode zur Anzeige des Transaktionsmenüs
    public void showTransactionMenu(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Transaktionsmenü ===");
            System.out.println("1. Transaktionshistorie anzeigen");
            System.out.println("2. Neue Transaktion erstellen");
            System.out.println("3. Transaktion löschen");
            System.out.println("0. Zurück");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    showTransactionHistory(kundenId);
                    break;
                case 2:
                    createTransaction(kundenId);
                    break;
                case 3:
                    deleteTransaction();
                    break;
                case 0:
                    System.out.println("Zurück zum Hauptmenü.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);
    }

    // Methode zur Anzeige der Transaktionshistorie
    public void showTransactionHistory(int kundenId) {
        List<Transaktion> transaktionen = transactionService.getTransactionsByKundenId(kundenId);
        System.out.println("=== Transaktionshistorie ===");
        for (Transaktion t : transaktionen) {
            System.out.println(t);
        }
    }

    // Methode zum Erstellen einer neuen Transaktion
    public void createTransaction(int kundenId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Aktien ID eingeben: ");
        int aktieId = scanner.nextInt();
        System.out.print("Anzahl der Aktien: ");
        int anzahl = scanner.nextInt();
        System.out.print("Preis pro Aktie: ");
        double preis = scanner.nextDouble();
        System.out.print("Transaktionstyp (Kauf/Verkauf): ");
        String typ = scanner.next();

        Transaktion transaktion = new Transaktion(0, kundenId, aktieId, anzahl, preis, new java.util.Date(), typ);
        if (transactionService.createTransaction(transaktion)) {
            System.out.println("Transaktion erfolgreich erstellt.");
        } else {
            System.out.println("Fehler beim Erstellen der Transaktion.");
        }
    }

    // Methode zum Löschen einer Transaktion
    public void deleteTransaction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Transaktions ID eingeben: ");
        int transaktionId = scanner.nextInt();

        if (transactionService.deleteTransaction(transaktionId)) {
            System.out.println("Transaktion erfolgreich gelöscht.");
        } else {
            System.out.println("Fehler beim Löschen der Transaktion.");
        }
    }
}
