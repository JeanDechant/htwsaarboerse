package com.boerse;

import com.boerse.controllers.BoerseController;
import com.boerse.models.*;

public class Main {

    public static void main(String[] args) {
        BoerseController controller = new BoerseController();

        // Test: Neuen Kunden hinzufügen
        Kunde neuerKunde = new Kunde(0, 1, "geheimesPasswort", 1000.00, 200.00);
        controller.addKunde(neuerKunde);

        // Test: Kunden anzeigen
        controller.showKunde(1);

        // Test: Neue Transaktion hinzufügen
        Transaktion neueTransaktion = new Transaktion(0, 1, 1, 50, "Kauf", "Offen", 20.00, true, new java.sql.Timestamp(System.currentTimeMillis()));
        controller.addTransaktion(neueTransaktion);

        // Test: Alle Transaktionen anzeigen
        controller.showTransaktionen(1);
    }
}
