package com.boerse;

import com.boerse.controllers.AktieController;
import com.boerse.controllers.KundeController;
import com.boerse.controllers.PortfolioController;
import com.boerse.controllers.TransactionController;
import com.boerse.controllers.CompanyController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KundeController kundeController = new KundeController();
        AktieController aktieController = new AktieController();
        PortfolioController portfolioController = new PortfolioController();
        TransactionController transactionController = new TransactionController();
        CompanyController companyController = new CompanyController();

        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Willkommen zur Börsenanwendung!");
        kundeController.showLoginMenu(); // Login-Option wird zuerst angezeigt

        do {
            System.out.println("=== Hauptmenü ===");
            System.out.println("1. Aktienoptionen");
            System.out.println("2. Portfolioverwaltung");
            System.out.println("3. Transaktionen verwalten");
            System.out.println("4. Firmen verwalten");
            System.out.println("0. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    aktieController.showAktienMenu();
                    break;
                case 2:
                    System.out.print("Bitte geben Sie Ihre Kunden-ID ein: ");
                    int kundenId = scanner.nextInt();
                    portfolioController.showPortfolioMenu(kundenId);
                    break;
                case 3:
                    System.out.print("Bitte geben Sie Ihre Kunden-ID ein: ");
                    int kundenIdTransaction = scanner.nextInt();
                    transactionController.showTransactionMenu(kundenIdTransaction);
                    break;
                case 4:
                    companyController.showCompanyMenu();
                    break;
                case 0:
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);

        scanner.close();
    }
}
