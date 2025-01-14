package org.example.app.view;

import org.example.app.entity.Employee;
import java.util.Scanner;

public class EmployeeUpdateView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Employee getUpdatedEmployee(Employee employee) {
        System.out.println("Updating employee with ID: " + employee.getIdEmployee());

        System.out.print("Enter new first name (current: " + employee.getFirstName() + "): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            employee.setFirstName(firstName);
            System.out.println("New first name: " + firstName);
        }

        System.out.print("Enter new last name (current: " + employee.getLastName() + "): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            employee.setLastName(lastName);
            System.out.println("New last name: " + lastName);
        }

        System.out.print("Enter new telephone (current: " + employee.getTelephone() + "): ");
        String telephone = scanner.nextLine();
        if (!telephone.isEmpty()) {
            employee.setTelephone(telephone);
            System.out.println("New telephone: " + telephone);
        }

        System.out.print("Enter new email (current: " + employee.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            employee.setEmail(email);
            System.out.println("New email: " + email);
        }

        System.out.print("Enter new company ID (current: " + employee.getIdCompany() + "): ");
        String idCompanyInput = scanner.nextLine();
        if (!idCompanyInput.isEmpty()) {
            int idCompany = Integer.parseInt(idCompanyInput);
            employee.setIdCompany(idCompany);
            System.out.println("New company ID: " + idCompany);
        }

        System.out.print("Enter new company type (current: " + employee.getCompanyType() + "): ");
        String companyType = scanner.nextLine();
        if (!companyType.isEmpty()) {
            employee.setCompanyType(companyType);
            System.out.println("New company type: " + companyType);
        }

        return employee;
    }
}


