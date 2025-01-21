package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDeleteRepository {
    public boolean deleteEmployeeByLastName(Employee employeeToDelete) {
        String sql = "DELETE FROM " + Constants.TABLE_EMPLOYEES + " WHERE last_Name = ? AND id_Employee = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, employeeToDelete.getLastName());
                pstmt.setInt(2, employeeToDelete.getIdEmployee());

                int rowsAffected = pstmt.executeUpdate();
                System.out.print("Employee " + employeeToDelete.getLastName() +
                        " has been successfully removed from the database");
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }
}

