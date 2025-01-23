package org.example.app.service;

import org.example.app.entity.Employee;
import org.example.app.repository.EmployeeCreateRepository;

import java.util.regex.Pattern;

public class EmployeeCreateService {
    private final EmployeeCreateRepository createRepository;

    public EmployeeCreateService(EmployeeCreateRepository createRepository) {
        this.createRepository = createRepository;
    }

    public String createEmployee(Employee employee) {
        if (!isValidEmail(employee.getEmail())) {
            return "Invalid email format. Email must be in lowercase.";
        }
        return createRepository.createEmployees(employee);
    }

    private boolean isValidEmail(String email) {
        if (!email.equals(email.toLowerCase())) {
            return false;
        }

        String emailRegex = "^[a-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}

