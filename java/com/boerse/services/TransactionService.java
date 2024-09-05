package com.boerse.services;

import com.boerse.models.Transaktion;
import com.boerse.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    // Methode zum Erstellen einer neuen Transaktion
    public boolean createTransaction(Transaktion transaktion) {
        String sql = "INSERT INTO Transaktion (transaktionId, kundenId, aktieId, anzahl, preis, datum, typ) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, transaktion.getTransaktionId());
            pstmt.setInt(2, transaktion.getKundenId());
            pstmt.setInt(3, transaktion.getAktieId());
            pstmt.setInt(4, transaktion.getAnzahl());
            pstmt.setDouble(5, transaktion.getPreis());
            pstmt.setDate(6, new java.sql.Date(transaktion.getDatum().getTime()));
            pstmt.setString(7, transaktion.getTyp());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Transaktion: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Rückgängig machen einer Transaktion (Löschen der Transaktion)
    public boolean deleteTransaction(int transaktionId) {
        String sql = "DELETE FROM Transaktion WHERE transaktionId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, transaktionId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der Transaktion: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Abrufen aller Transaktionen eines Kunden
    public List<Transaktion> getTransactionsByKundenId(int kundenId) {
        List<Transaktion> transaktionen = new ArrayList<>();
        String sql = "SELECT * FROM Transaktion WHERE kundenId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, kundenId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Transaktion transaktion = new Transaktion(
                    rs.getInt("transaktionId"),
                    rs.getInt("kundenId"),
                    rs.getInt("aktieId"),
                    rs.getInt("anzahl"),
                    rs.getDouble("preis"),
                    rs.getDate("datum"),
                    rs.getString("typ")
                );
                transaktionen.add(transaktion);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Transaktionen: " + e.getMessage());
        }
        return transaktionen;
    }

    // Methode zum Abrufen einer Transaktion anhand der TransaktionId
    public Transaktion getTransactionById(int transaktionId) {
        String sql = "SELECT * FROM Transaktion WHERE transaktionId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, transaktionId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Transaktion(
                    rs.getInt("transaktionId"),
                    rs.getInt("kundenId"),
                    rs.getInt("aktieId"),
                    rs.getInt("anzahl"),
                    rs.getDouble("preis"),
                    rs.getDate("datum"),
                    rs.getString("typ")
                );
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Transaktion: " + e.getMessage());
        }
        return null;
    }

    // Methode zum Abrufen aller Transaktionen
    public List<Transaktion> getAllTransactions() {
        List<Transaktion> transaktionen = new ArrayList<>();
        String sql = "SELECT * FROM Transaktion";
        
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Transaktion transaktion = new Transaktion(
                    rs.getInt("transaktionId"),
                    rs.getInt("kundenId"),
                    rs.getInt("aktieId"),
                    rs.getInt("anzahl"),
                    rs.getDouble("preis"),
                    rs.getDate("datum"),
                    rs.getString("typ")
                );
                transaktionen.add(transaktion);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Transaktionen: " + e.getMessage());
        }
        return transaktionen;
    }
}
