package com.boerse.services;

import com.boerse.models.Kunde;
import com.boerse.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KundeService {
    
    // Methode zum Hinzufügen eines neuen Kunden
    public boolean addKunde(Kunde kunde) {
        String sql = "INSERT INTO Kunde (kundenId, name, password, guthaben, kredit, isAdmin) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, kunde.getKundenId());
            pstmt.setString(2, kunde.getName());
            pstmt.setString(3, kunde.getPassword());
            pstmt.setDouble(4, kunde.getGuthaben());
            pstmt.setDouble(5, kunde.getKredit());
            pstmt.setBoolean(6, kunde.isAdmin());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen des Kunden: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Login eines Kunden
    public Kunde login(int kundenId, String password) {
        String sql = "SELECT * FROM Kunde WHERE kundenId = ? AND password = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, kundenId);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Kunde(
                    rs.getInt("kundenId"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getDouble("guthaben"),
                    rs.getDouble("kredit"),
                    rs.getBoolean("isAdmin")
                );
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Login: " + e.getMessage());
        }
        return null;
    }

    // Methode zum Ändern eines Kundenpassworts
    public boolean changePassword(int kundenId, String newPassword) {
        String sql = "UPDATE Kunde SET password = ? WHERE kundenId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, kundenId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Ändern des Passworts: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Anzeigen aller Kunden
    public List<Kunde> getAllKunden() {
        List<Kunde> kundenListe = new ArrayList<>();
        String sql = "SELECT * FROM Kunde";
        
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Kunde kunde = new Kunde(
                    rs.getInt("kundenId"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getDouble("guthaben"),
                    rs.getDouble("kredit"),
                    rs.getBoolean("isAdmin")
                );
                kundenListe.add(kunde);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Kunden: " + e.getMessage());
        }
        return kundenListe;
    }
}
