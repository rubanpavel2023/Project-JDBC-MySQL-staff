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

public class CompanyReadRepository {


    public List<Company> readCompaniesByLastNameStartsWith(char initial) {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM " + Constants.TABLE_COMPANIES + " WHERE name_Company LIKE ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, initial + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company();
                    company.setIdCompany(rs.getInt("id_Company"));
                    company.setNameCompany(rs.getString("name_Company"));
                    companies.add(company);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        return Optional.ofNullable(companies.isEmpty() ? null : companies)
                .orElse(Collections.emptyList());
    }


    public List<Company> readAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String sqlAll = "SELECT * FROM " + Constants.TABLE_COMPANIES;
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sqlAll)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Company company = new Company();
                    company.setIdCompany(rs.getInt("id_Company"));
                    company.setNameCompany(rs.getString("name_Company"));
                    companies.add(company);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        return Optional.ofNullable(companies.isEmpty() ? null : companies)
                .orElse(Collections.emptyList());

    }

    public List<Integer> readIdCompanies() {
        String sql = "SELECT DISTINCT id_Company " + "FROM " + Constants.TABLE_COMPANIES;
        List<Integer> allIdCompanies = new ArrayList<>();

        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    allIdCompanies.add(rs.getInt("id_Company"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        return Optional.ofNullable(allIdCompanies.isEmpty() ? null : allIdCompanies)
                .orElse(Collections.emptyList());


    }

}



