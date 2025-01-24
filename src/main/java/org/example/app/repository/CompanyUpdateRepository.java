package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyUpdateRepository {

    public boolean updateCompany(Company company) {
        if (company == null) {
            return false;
        }
        String sql = "UPDATE " + Constants.TABLE_COMPANIES +
                " SET name_Company = ? WHERE id_Company = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, company.getNameCompany());
                pstmt.setInt(2, company.getIdCompany());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    return true;
                } else {
                    System.out.println("No changes detected. No update needed.");
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }
}
