package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyUpdateRepository {

    public String updateCompany(Company company) {
        String sql = "UPDATE " + Constants.TABLE_COMPANIES +
                " SET name_Company = ? WHERE id_Company = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, company.getNameCompany());
                pstmt.setInt(2, company.getIdCompany());
                pstmt.executeUpdate();
                return Constants.DATA_COMPANY_UPDATE_MSG;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }
}



