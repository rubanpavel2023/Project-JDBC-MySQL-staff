package org.example.app.view;

import org.example.app.entity.Employee;

import java.util.Scanner;

public class EmployeeUpdateView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Employee getUpdatedEmployee(Employee originalEmployee) {

        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setIdEmployee(originalEmployee.getIdEmployee());

        System.out.print("Enter new first name (current: " + originalEmployee.getFirstName() + "): ");
        String firstName = scanner.nextLine();
        employeeToUpdate.setFirstName(firstName.isEmpty() ? originalEmployee.getFirstName() : firstName);
        System.out.println("New first name: " + employeeToUpdate.getFirstName());

        System.out.print("Enter new last name (current: " + originalEmployee.getLastName() + "): ");
        String lastName = scanner.nextLine();
        employeeToUpdate.setLastName(lastName.isEmpty() ? originalEmployee.getLastName() : lastName);
        System.out.println("New last name: " + employeeToUpdate.getLastName());

        System.out.print("Enter new position (current: " + originalEmployee.getPosition() + "): ");
        String telephone = scanner.nextLine();
        employeeToUpdate.setPosition(telephone.isEmpty() ? originalEmployee.getPosition() : telephone);
        System.out.println("New position: " + employeeToUpdate.getPosition());

        System.out.print("Enter new email (current: " + originalEmployee.getEmail() + "): ");
        String email = scanner.nextLine();
        employeeToUpdate.setEmail(email.isEmpty() ? originalEmployee.getEmail() : email);
        System.out.println("New email: " + employeeToUpdate.getEmail());

        System.out.print("Enter new company ID (current: " + originalEmployee.getIdCompany() + "): ");
        String idCompanyInput = scanner.nextLine();
        employeeToUpdate.setIdCompany(idCompanyInput.isEmpty() ? originalEmployee.getIdCompany() : Integer.parseInt(idCompanyInput));
        System.out.println("New company ID: " + employeeToUpdate.getIdCompany());

        if (!isEmployeeDataChanged(originalEmployee, employeeToUpdate)) {
            System.out.println("No changes detected. Employee data remains unchanged.");
            return null;
        }

        return employeeToUpdate;
    }

    private static boolean isEmployeeDataChanged(Employee original, Employee updated) {
        return !original.getFirstName().equals(updated.getFirstName()) ||
                !original.getLastName().equals(updated.getLastName()) ||
                !original.getPosition().equals(updated.getPosition()) ||
                !original.getEmail().equals(updated.getEmail()) ||
                original.getIdCompany() != updated.getIdCompany();
    }
}



