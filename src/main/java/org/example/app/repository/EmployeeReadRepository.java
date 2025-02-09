package org.example.app.repository;

import org.example.app.constants.Constants;
import org.example.app.database.DBConn;
import org.example.app.entity.Employee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeReadRepository {


    public List<Employee> readEmployeesByLastNameStartsWith(char initial) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT id_Employee, employees.first_Name, employees.last_Name, employees.position, employees.email, employees.id_Company, companies.name_Company " +
                "FROM employees " +
                "JOIN companies ON employees.id_Company = companies.id_Company " +
                "WHERE employees.last_Name LIKE ?";

        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                System.err.println(Constants.DATABASE_CONNECTION_FAILED_MSG);
                return Collections.emptyList();
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
                    employee.setNameCompany(rs.getString("name_Company"));
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        return Optional.ofNullable(employees.isEmpty() ? null : employees)
                .orElse(Collections.emptyList());
    }


    public List<Employee> readAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sqlAll = "SELECT employees.id_Employee, employees.first_Name, employees.last_Name, employees.position, employees.email, employees.id_Company, companies.name_Company " +
                "FROM employees " +
                "JOIN companies ON employees.id_Company = companies.id_Company";

        try (Connection conn = DBConn.connect()) {
            if (conn == null) {
                System.err.println(Constants.DATABASE_CONNECTION_FAILED_MSG);
                return Collections.emptyList();
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sqlAll)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setIdEmployee(rs.getInt("id_Employee"));
                    employee.setFirstName(rs.getString("first_Name"));
                    employee.setLastName(rs.getString("last_Name"));
                    employee.setPosition(rs.getString("position"));
                    employee.setEmail(rs.getString("email"));
                    employee.setIdCompany(rs.getInt("id_Company"));
                    employee.setNameCompany(rs.getString("name_Company"));
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        return Optional.ofNullable(employees.isEmpty() ? null : employees)
                .orElse(Collections.emptyList());
    }

}





