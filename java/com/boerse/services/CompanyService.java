package com.boerse.services;

import com.boerse.models.Company;
import com.boerse.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyService {

    // Methode zum Hinzufügen einer neuen Firma
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO Company (companyId, name, kuerzel, land, branche) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, company.getCompanyId());
            pstmt.setString(2, company.getName());
            pstmt.setString(3, company.getKuerzel());
            pstmt.setString(4, company.getLand());
            pstmt.setString(5, company.getBranche());
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen der Firma: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Abrufen aller Firmen
    public List<Company> getAllCompanies() {
        List<Company> companyList = new ArrayList<>();
        String sql = "SELECT * FROM Company";
        
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                Company company = new Company(
                    rs.getInt("companyId"),
                    rs.getString("name"),
                    rs.getString("kuerzel"),
                    rs.getString("land"),
                    rs.getString("branche")
                );
                companyList.add(company);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Firmen: " + e.getMessage());
        }
        return companyList;
    }

    // Methode zum Ändern einer Firma
    public boolean updateCompany(int companyId, String newName, String newKuerzel, String newLand, String newBranche) {
        String sql = "UPDATE Company SET name = ?, kuerzel = ?, land = ?, branche = ? WHERE companyId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, newName);
            pstmt.setString(2, newKuerzel);
            pstmt.setString(3, newLand);
            pstmt.setString(4, newBranche);
            pstmt.setInt(5, companyId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Ändern der Firma: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Löschen einer Firma
    public boolean deleteCompany(int companyId) {
        String sql = "DELETE FROM Company WHERE companyId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, companyId);
            pstmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der Firma: " + e.getMessage());
            return false;
        }
    }

    // Methode zum Abrufen einer Firma anhand der companyId
    public Company getCompanyById(int companyId) {
        String sql = "SELECT * FROM Company WHERE companyId = ?";
        
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, companyId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Company(
                    rs.getInt("companyId"),
                    rs.getString("name"),
                    rs.getString("kuerzel"),
                    rs.getString("land"),
                    rs.getString("branche")
                );
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Firma: " + e.getMessage());
        }
        return null;
    }
}
