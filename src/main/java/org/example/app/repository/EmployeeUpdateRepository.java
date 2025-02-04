package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeUpdateRepository {
    public String updateEmployee(Employee employeeToUpdate) {
        String sql = "UPDATE " + Constants.TABLE_EMPLOYEES +
                " SET first_Name = ?, last_Name = ?, position = ?, email = ?, id_Company = ? WHERE id_Employee = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, employeeToUpdate.getFirstName());
                pstmt.setString(2, employeeToUpdate.getLastName());
                pstmt.setString(3, employeeToUpdate.getPosition());
                pstmt.setString(4, employeeToUpdate.getEmail());
                pstmt.setInt(5, employeeToUpdate.getIdCompany());
                pstmt.setInt(6, employeeToUpdate.getIdEmployee());
                pstmt.executeUpdate();
                return Constants.DATA_EMPLOYEE_UPDATE_MSG;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }
}
