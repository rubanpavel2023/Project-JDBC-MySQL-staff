package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyUpdateRepository {

    public String updateCompany(Company companyToUpdate) {
        String sql = "UPDATE " + Constants.TABLE_COMPANIES +
                " SET name_Company = ? WHERE id_Company = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                return Constants.DATABASE_CONNECTION_FAILED_MSG;
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, companyToUpdate.getNameCompany());
                pstmt.setInt(2, companyToUpdate.getIdCompany());
                pstmt.executeUpdate();
                return Constants.DATA_COMPANY_UPDATE_MSG;
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
            return "Database error occurred: " + e.getMessage();
        } catch (RuntimeException e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return "Unexpected error: " + e.getMessage();
        }
    }

}




