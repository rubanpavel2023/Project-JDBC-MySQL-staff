package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EmployeeReadRepository {
    public Optional<Employee> readEmployee(int idEmployee) {
        String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES + " WHERE id_Employee = ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, idEmployee);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setIdEmployee(rs.getInt("id_Employee"));
                    employee.setFirstName(rs.getString("first_Name"));
                    employee.setLastName(rs.getString("last_Name"));
                    employee.setPosition(rs.getString("position"));
                    employee.setEmail(rs.getString("email"));
                    employee.setIdCompany(rs.getInt("id_Company"));
                    employee.setCompanyType(rs.getString("company_Type"));
                    return Optional.of(employee);
                } else {
                    System.out.println("No employee found with ID: " + idEmployee);
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database error: " + e.getMessage(), e);
        }
    }


    public Optional<List<Employee>> readEmployeesByLastNameStartsWith(char initial) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM " + Constants.TABLE_EMPLOYEES + " WHERE last_Name LIKE ?";
        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                throw new RuntimeException("Failed to establish database connection");
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, initial + "%");
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
        return Optional.ofNullable(employees.isEmpty() ? null : employees);
        //return employees.isEmpty() ? Optional.empty() : Optional.of(employees);
    }

}




