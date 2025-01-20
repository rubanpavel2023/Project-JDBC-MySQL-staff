package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeCreateRepository {
    public String createEmployees(Employee employeeToCreate) {

        String sql = "INSERT INTO" + Constants.TABLE_EMPLOYEES +
                " (first_Name, last_Name, position, email, id_Company, company_Type) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, employeeToCreate.getFirstName());
                pstmt.setString(2, employeeToCreate.getLastName());
                pstmt.setString(3, employeeToCreate.getPosition());
                pstmt.setString(4, employeeToCreate.getEmail());
                pstmt.setInt(5, employeeToCreate.getIdCompany());
                pstmt.setString(6, employeeToCreate.getCompanyType());
                pstmt.executeUpdate();
                return Constants.DATA_EMPLOYEE_INSERT_MSG;
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
