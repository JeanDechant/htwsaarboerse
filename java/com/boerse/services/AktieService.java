package com.boerse.services;

import com.boerse.models.Aktie;
import com.boerse.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AktieService {

    // Methode zum Hinzufügen einer neuen Aktie
    public boolean addAktie(Aktie aktie) {
        String sql = "INSERT INTO Aktie (aktieId, name, kuerzel, companyId, preis, erstellungsdatum) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, aktie.getAktieId());
            pstmt.setString(2, aktie.getName());
            pstmt.setString(3, aktie.getKuerzel());
            pstmt.setInt(4, aktie.getCompanyId());
            pstmt.setDouble(5, aktie.getPreis());
            pstmt.setDate(6, new java.sql.Date(aktie.getErstellungsdatum().getTime()));
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen der Aktie: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Abrufen aller Aktien
    public List<Aktie> getAllAktien() {
        List<Aktie> aktienListe = new ArrayList<>();
        String sql = "SELECT * FROM Aktie";
        
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Aktie aktie = new Aktie(
                    rs.getInt("aktieId"),
                    rs.getString("name"),
                    rs.getString("kuerzel"),
                    rs.getInt("companyId"),
                    rs.getDouble("preis"),
                    rs.getDate("erstellungsdatum")
                );
                aktienListe.add(aktie);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Aktien: " + e.getMessage());
        }
        return aktienListe;
    }

    // Methode zum Ändern des Preises einer Aktie
    public boolean updateAktienPreis(int aktieId, double neuerPreis) {
        String sql = "UPDATE Aktie SET preis = ? WHERE aktieId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setDouble(1, neuerPreis);
            pstmt.setInt(2, aktieId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Ändern des Aktienpreises: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Löschen einer Aktie
    public boolean deleteAktie(int aktieId) {
        String sql = "DELETE FROM Aktie WHERE aktieId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, aktieId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der Aktie: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Abrufen einer Aktie anhand der aktieId
    public Aktie getAktieById(int aktieId) {
        String sql = "SELECT * FROM Aktie WHERE aktieId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, aktieId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Aktie(
                    rs.getInt("aktieId"),
                    rs.getString("name"),
                    rs.getString("kuerzel"),
                    rs.getInt("companyId"),
                    rs.getDouble("preis"),
                    rs.getDate("erstellungsdatum")
                );
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Aktie: " + e.getMessage());
        }
        return null;
    }
}
