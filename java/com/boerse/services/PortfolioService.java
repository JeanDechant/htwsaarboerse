package com.boerse.services;

import com.boerse.models.Aktie;
import com.boerse.models.Portfolio;
import com.boerse.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PortfolioService {

    // Methode zum Erstellen eines neuen Portfolios
    public boolean createPortfolio(int portfolioId, int kundenId) {
        String sql = "INSERT INTO Portfolio (portfolioId, kundenId) VALUES (?, ?)";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, portfolioId);
            pstmt.setInt(2, kundenId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen des Portfolios: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Hinzufügen von Aktien zum Portfolio
    public boolean addAktieToPortfolio(int portfolioId, Aktie aktie, int anzahl) {
        String sql = "INSERT INTO Portfolio_Aktie (portfolioId, aktieId, anzahl) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE anzahl = anzahl + ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, portfolioId);
            pstmt.setInt(2, aktie.getAktieId());
            pstmt.setInt(3, anzahl);
            pstmt.setInt(4, anzahl); // Bei Duplikat wird die Anzahl aktualisiert
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen der Aktie zum Portfolio: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Entfernen von Aktien aus dem Portfolio
    public boolean removeAktieFromPortfolio(int portfolioId, Aktie aktie, int anzahl) {
        String sql = "UPDATE Portfolio_Aktie SET anzahl = anzahl - ? WHERE portfolioId = ? AND aktieId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, anzahl);
            pstmt.setInt(2, portfolioId);
            pstmt.setInt(3, aktie.getAktieId());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Entfernen der Aktie aus dem Portfolio: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Anzeigen des Portfoliowerts
    public double getPortfolioValue(int portfolioId) {
        String sql = "SELECT SUM(a.preis * pa.anzahl) as totalValue " +
                     "FROM Portfolio_Aktie pa " +
                     "JOIN Aktie a ON pa.aktieId = a.aktieId " +
                     "WHERE pa.portfolioId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, portfolioId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getDouble("totalValue");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen des Portfoliowerts: " + e.getMessage());
        }
        return 0.0;
    }

    // Methode zum Löschen eines Portfolios
    public boolean deletePortfolio(int portfolioId) {
        String sql = "DELETE FROM Portfolio WHERE portfolioId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, portfolioId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen des Portfolios: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Anzeigen aller Portfolios eines Kunden
    public List<Portfolio> getPortfoliosByKundenId(int kundenId) {
        List<Portfolio> portfolios = new ArrayList<>();
        String sql = "SELECT * FROM Portfolio WHERE kundenId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, kundenId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Portfolio portfolio = new Portfolio(rs.getInt("portfolioId"), rs.getInt("kundenId"));
                portfolios.add(portfolio);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Portfolios: " + e.getMessage());
        }
        return portfolios;
    }
}
