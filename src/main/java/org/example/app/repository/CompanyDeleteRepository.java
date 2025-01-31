package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CompanyDeleteRepository {
    public void deleteCompany(Company companyToDelete) {
        String sql = "DELETE FROM " + Constants.TABLE_COMPANIES + " WHERE name_Company = ? AND id_Company = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, companyToDelete.getNameCompany());
                pstmt.setInt(2, companyToDelete.getIdCompany());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("<Company " + companyToDelete.getNameCompany() +
                            " has been successfully removed from the database>");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

    /*public String deleteAllCompanies() {
        String sqlAll = "DELETE FROM " + Constants.TABLE_COMPANIES;
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sqlAll)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company();
                    pstmt.setString(1, companyToDelete.getNameCompany());
                    pstmt.setInt(2, companyToDelete.getIdCompany());

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        return Optional.ofNullable(companies.isEmpty() ? null : companies)
                .orElse(Collections.emptyList());

    }
}*/

