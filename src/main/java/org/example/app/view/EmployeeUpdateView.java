package org.example.app.view;

import org.example.app.entity.Employee;

import java.util.Scanner;

public class EmployeeUpdateView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Employee getUpdatedEmployee(Employee originalEmployee) {
        System.out.println("Updating employee with ID: " + originalEmployee.getIdEmployee());

        Employee updatedEmployee = new Employee();
        updatedEmployee.setIdEmployee(originalEmployee.getIdEmployee());

        System.out.print("Enter new first name (current: " + originalEmployee.getFirstName() + "): ");
        String firstName = scanner.nextLine();
        updatedEmployee.setFirstName(firstName.isEmpty() ? originalEmployee.getFirstName() : firstName);
        System.out.println("New first name: " + updatedEmployee.getFirstName());

        System.out.print("Enter new last name (current: " + originalEmployee.getLastName() + "): ");
        String lastName = scanner.nextLine();
        updatedEmployee.setLastName(lastName.isEmpty() ? originalEmployee.getLastName() : lastName);
        System.out.println("New last name: " + updatedEmployee.getLastName());

        System.out.print("Enter new telephone (current: " + originalEmployee.getTelephone() + "): ");
        String telephone = scanner.nextLine();
        updatedEmployee.setTelephone(telephone.isEmpty() ? originalEmployee.getTelephone() : telephone);
        System.out.println("New telephone: " + updatedEmployee.getTelephone());

        System.out.print("Enter new email (current: " + originalEmployee.getEmail() + "): ");
        String email = scanner.nextLine();
        updatedEmployee.setEmail(email.isEmpty() ? originalEmployee.getEmail() : email);
        System.out.println("New email: " + updatedEmployee.getEmail());

        System.out.print("Enter new company ID (current: " + originalEmployee.getIdCompany() + "): ");
        String idCompanyInput = scanner.nextLine();
        updatedEmployee.setIdCompany(idCompanyInput.isEmpty() ? originalEmployee.getIdCompany() : Integer.parseInt(idCompanyInput));
        System.out.println("New company ID: " + updatedEmployee.getIdCompany());

        System.out.print("Enter new company type (current: " + originalEmployee.getCompanyType() + "): ");
        String companyType = scanner.nextLine();
        updatedEmployee.setCompanyType(companyType.isEmpty() ? originalEmployee.getCompanyType() : companyType);
        System.out.println("New company type: " + updatedEmployee.getCompanyType());

        if (!isEmployeeDataChanged(originalEmployee, updatedEmployee)) {
            System.out.println("No changes detected. Employee data remains unchanged.");
            return null;
        }

        return updatedEmployee;
    }

    private static boolean isEmployeeDataChanged(Employee original, Employee updated) {
        return !original.getFirstName().equals(updated.getFirstName()) ||
                !original.getLastName().equals(updated.getLastName()) ||
                !original.getTelephone().equals(updated.getTelephone()) ||
                !original.getEmail().equals(updated.getEmail()) ||
                original.getIdCompany() != updated.getIdCompany() ||
                !original.getCompanyType().equals(updated.getCompanyType());
    }
}



