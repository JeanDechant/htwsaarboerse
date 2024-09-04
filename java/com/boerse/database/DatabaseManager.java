package com.boerse.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final String url = "jdbc:mysql://localhost:3306/boerse";
    private final String user = "root";
    private final String password = "password";  // Setze das richtige Passwort

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Datenbankverbindung hergestellt.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
