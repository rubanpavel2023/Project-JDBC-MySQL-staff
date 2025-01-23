package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyCreateRepository {

    public String createCompany(Company companyToCreate) {
        String sql = "INSERT INTO " + Constants.TABLE_COMPANIES +
                " (name_Company) " + "VALUES(?)";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                return "Failed to establish database connection";
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, companyToCreate.getNameCompany());
                pstmt.executeUpdate();
                return Constants.DATA_COMPANY_INSERT_MSG;
            }
        } catch (SQLException e) {
            return "Database error: " + e.getMessage();
        }
    }
}

