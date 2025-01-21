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
    /*перенести метод readEmployees в контроллер*/
    public void readEmployees(List<Employee> employees) {
        System.out.println("Below is the list of employees based on your query:");

        employees.forEach(employee -> System.out.println(
                "ID: " + employee.getIdEmployee() +
                        ", First Name: " + employee.getFirstName() +
                        ", Last Name: " + employee.getLastName() +
                        ", Position: " + employee.getPosition() +
                        ", Email: " + employee.getEmail() +
                        ", Company ID: " + employee.getIdCompany()
        ));
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




