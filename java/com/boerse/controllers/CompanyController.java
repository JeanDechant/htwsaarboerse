package com.boerse.controllers;

import com.boerse.models.Company;
import com.boerse.services.CompanyService;

import java.util.List;
import java.util.Scanner;

public class CompanyController {

    private final CompanyService companyService;

    public CompanyController() {
        this.companyService = new CompanyService();
    }

    // Methode zur Anzeige des Firmenmenüs
    public void showCompanyMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Firmenmenü ===");
            System.out.println("1. Alle Firmen anzeigen");
            System.out.println("2. Firma hinzufügen");
            System.out.println("3. Firma ändern");
            System.out.println("4. Firma löschen");
            System.out.println("0. Zurück");
            System.out.print("Wählen Sie eine Option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayAllCompanies();
                    break;
                case 2:
                    addCompany();
                    break;
                case 3:
                    updateCompany();
                    break;
                case 4:
                    deleteCompany();
                    break;
                case 0:
                    System.out.println("Zurück zum Hauptmenü.");
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }

        } while (option != 0);
    }

    // Methode zur Anzeige aller Firmen
    public void displayAllCompanies() {
        List<Company> companyList = companyService.getAllCompanies();
        System.out.println("=== Verfügbare Firmen ===");
        for (Company company : companyList) {
            System.out.println(company);
        }
    }

    // Methode zum Hinzufügen einer neuen Firma
    public void addCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Firmenname eingeben: ");
        String name = scanner.next();
        System.out.print("Firmenkürzel eingeben: ");
        String kuerzel = scanner.next();
        System.out.print("Sitzland eingeben: ");
        String land = scanner.next();
        System.out.print("Branche eingeben: ");
        String branche = scanner.next();

        Company company = new Company(0, name, kuerzel, land, branche);
        if (companyService.addCompany(company)) {
            System.out.println("Firma erfolgreich hinzugefügt.");
        } else {
            System.out.println("Fehler beim Hinzufügen der Firma.");
        }
    }

    // Methode zum Ändern einer Firma
    public void updateCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Firmen ID eingeben: ");
        int companyId = scanner.nextInt();
        System.out.print("Neuer Firmenname eingeben: ");
        String newName = scanner.next();
        System.out.print("Neues Firmenkürzel eingeben: ");
        String newKuerzel = scanner.next();
        System.out.print("Neues Sitzland eingeben: ");
        String newLand = scanner.next();
        System.out.print("Neue Branche eingeben: ");
        String newBranche = scanner.next();

        if (companyService.updateCompany(companyId, newName, newKuerzel, newLand, newBranche)) {
            System.out.println("Firma erfolgreich geändert.");
        } else {
            System.out.println("Fehler beim Ändern der Firma.");
        }
    }

    // Methode zum Löschen einer Firma
    public void deleteCompany() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Firmen ID eingeben: ");
        int companyId = scanner.nextInt();

        if (companyService.deleteCompany(companyId)) {
            System.out.println("Firma erfolgreich gelöscht.");
        } else {
            System.out.println("Fehler beim Löschen der Firma.");
        }
    }
}
