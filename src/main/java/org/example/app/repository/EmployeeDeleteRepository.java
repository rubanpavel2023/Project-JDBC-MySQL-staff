package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDeleteRepository {
    public void deleteEmployeeByLastName(Employee employeeToDelete) {
        String sql = "DELETE FROM " + Constants.TABLE_EMPLOYEES + " WHERE last_Name = ? AND id_Employee = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                System.err.println(Constants.DATABASE_CONNECTION_FAILED_MSG);
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, employeeToDelete.getLastName());
                pstmt.setInt(2, employeeToDelete.getIdEmployee());
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("<Employee " + employeeToDelete.getLastName() +
                            " has been successfully removed from the database>");
                } else
                    System.out.println("Employee not found. Please check the details and try again");

            }
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

}



