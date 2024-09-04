package com.boerse.services;

import com.boerse.models.*;
import com.boerse.database.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoerseService {

    private Connection connection;

    public BoerseService() {
        this.connection = DatabaseManager.connect(); // Stellt eine Verbindung zur Datenbank her
    }
//	this is the End
//	hold your breath and count to ten
//
//
//
    // Methode zum Erstellen eines neuen Kunden
    public void createKunde(Kunde kunde) throws SQLException {
        String sql = "INSERT INTO Kunde (person_id, passwort, guthaben, credit) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, kunde.getPersonId());
            stmt.setString(2, kunde.getPasswort());
            stmt.setDouble(3, kunde.getGuthaben());
            stmt.setDouble(4, kunde.getCredit());
            stmt.executeUpdate();
        }
    }

    // Methode zum Abrufen eines Kunden anhand der ID
    public Kunde getKundeById(int kundenId) throws SQLException {
        String sql = "SELECT * FROM Kunde WHERE kunden_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, kundenId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Kunde(
                    rs.getInt("kunden_id"),
                    rs.getInt("person_id"),
                    rs.getString("passwort"),
                    rs.getDouble("guthaben"),
                    rs.getDouble("credit")
                );
            }
        }
        return null;
    }

    // Methode zum Erstellen einer neuen Transaktion
    public void createTransaktion(Transaktion transaktion) throws SQLException {
        String sql = "INSERT INTO Transaktion (kunden_id, aktie_id, numberOfStock, sortOfTransaction, status, costPerStock, boughtStock, time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaktion.getKundenId());
            stmt.setInt(2, transaktion.getAktieId());
            stmt.setInt(3, transaktion.getNumberOfStock());
            stmt.setString(4, transaktion.getSortOfTransaction());
            stmt.setString(5, transaktion.getStatus());
            stmt.setDouble(6, transaktion.getCostPerStock());
            stmt.setBoolean(7, transaktion.isBoughtStock());
            stmt.setTimestamp(8, transaktion.getTime());
            stmt.executeUpdate();
        }
    }

    // Methode zum Abrufen aller Transaktionen eines Kunden
    public List<Transaktion> getTransaktionenByKundenId(int kundenId) throws SQLException {
        String sql = "SELECT * FROM Transaktion WHERE kunden_id = ?";
        List<Transaktion> transaktionen = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, kundenId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                transaktionen.add(new Transaktion(
                    rs.getInt("transaktion_id"),
                    rs.getInt("kunden_id"),
                    rs.getInt("aktie_id"),
                    rs.getInt("numberOfStock"),
                    rs.getString("sortOfTransaction"),
                    rs.getString("status"),
                    rs.getDouble("costPerStock"),
                    rs.getBoolean("boughtStock"),
                    rs.getTimestamp("time")
                ));
            }
        }
        return transaktionen;
    }

    // Methode zum Erstellen eines neuen Portfolios
    public void createPortfolio(Portfolio portfolio) throws SQLException {
        String sql = "INSERT INTO Portfolio (kunden_id, numberOfStock, completeWorth) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, portfolio.getKundenId());
            stmt.setInt(2, portfolio.getNumberOfStock());
            stmt.setDouble(3, portfolio.getCompleteWorth());
            stmt.executeUpdate();
        }
    }
}
