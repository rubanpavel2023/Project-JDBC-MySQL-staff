package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDeleteRepository {
    public boolean deleteCompanyByName(Company companyToDelete) {
        String sql = "DELETE FROM " + Constants.TABLE_COMPANIES + " WHERE name_Company = ? AND id_Company = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, companyToDelete.getNameCompany());
                pstmt.setInt(2, companyToDelete.getIdCompany());

                int rowsAffected = pstmt.executeUpdate();
                System.out.print("Employee " + companyToDelete.getNameCompany() +
                        " has been successfully removed from the database");
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }
}
