package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeUpdateRepository {
    /*public List<Employee> findEmployeesByLastName(String lastName) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES + " WHERE last_Name = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, lastName);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setIdEmployee(rs.getInt("id_Employee"));
                    employee.setFirstName(rs.getString("first_Name"));
                    employee.setLastName(rs.getString("last_Name"));
                    employee.setPosition(rs.getString("position"));
                    employee.setEmail(rs.getString("email"));
                    employee.setIdCompany(rs.getInt("id_Company"));
                    employee.setCompanyType(rs.getString("company_Type"));
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
        Optional<List<Employee>> optionalEmployees = Optional.ofNullable(employees.isEmpty() ? null : employees);
        if (optionalEmployees.isEmpty()) {
            System.out.println("No employees found with the last name: " + lastName);
            return new ArrayList<>();
        } else {
            return optionalEmployees.get();

        }
    }

    public boolean updateEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        String sql = "UPDATE " + Constants.TABLE_EMPLOYEES +
                " SET first_Name = ?, last_Name = ?, " +
                "position = ?, email = ?, " +
                "id_Company = ? WHERE id_Employee = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, employee.getFirstName());
                pstmt.setString(2, employee.getLastName());
                pstmt.setString(3, employee.getPosition());
                pstmt.setString(4, employee.getEmail());
                pstmt.setInt(5, employee.getIdCompany());
                pstmt.setInt(6, employee.getIdEmployee());

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Employee updated successfully");
                    return true;
                } else {
                    System.out.println("No changes detected. No update needed.");
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }*/
}
