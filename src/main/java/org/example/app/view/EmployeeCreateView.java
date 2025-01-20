package org.example.app.view;

import org.example.app.entity.Company;
import org.example.app.entity.Employee;

import java.util.Scanner;

public class EmployeeCreateView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Employee getEmployeeDetails() {
        Employee employeeToCreate = new Employee();

        System.out.println("Enter employee firstName: ");
        String firstName = scanner.nextLine();
        employeeToCreate.setFirstName(firstName);

        System.out.println("Enter employee lastName: ");
        String lastName = scanner.nextLine();
        employeeToCreate.setFirstName(lastName);

        System.out.println("Enter employee position: ");
        String position = scanner.nextLine();
        employeeToCreate.setPosition(position);

        System.out.println("Enter employee email: ");
        String email = scanner.nextLine();
        employeeToCreate.setEmail(email);

        System.out.println("Enter employee idCompany: ");
        int idCompany = scanner.nextInt();
        employeeToCreate.setIdCompany(idCompany);

        System.out.println("Enter employee companyType: ");
        String companyType = scanner.nextLine();
        employeeToCreate.setCompanyType(companyType);

        return employeeToCreate;
    }
}

