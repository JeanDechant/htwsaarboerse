package com.boerse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/boerse";
    private static final String USER = "root";
    private static final String PASSWORD = "password";  // Passwort anpassen

    // Methode zur Herstellung der Datenbankverbindung
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Datenbankverbindung hergestellt.");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Datenbankverbindung: " + e.getMessage());
        }
        return connection;
    }

    // Methode zur Schließung der Datenbankverbindung
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Datenbankverbindung geschlossen.");
            } catch (SQLException e) {
                System.out.println("Fehler beim Schließen der Datenbankverbindung: " + e.getMessage());
            }
        }
    }
}
