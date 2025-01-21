package org.example.app.view;
import org.example.app.entity.Employee;

import java.util.Scanner;
import java.util.List;


public class EmployeeSelectionView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Employee selectEmployee(List<Employee> employees) {
        if (employees.size() == 1) {
            return employees.get(0);
        }
        System.out.println("Select an employee from the list:");
        for (int i = 0; i < employees.size(); i++) {
            Employee selectedEmployee = employees.get(i);
            System.out.println((i + 1) + ". ID: " + selectedEmployee.getIdEmployee() +
                    ", Name: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName() +
                    ", Position: " + selectedEmployee.getPosition() +
                    ", Email: " + selectedEmployee.getEmail());

        }
        System.out.print("Enter the number of the employee to update: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return employees.get(choice - 1);
    }
}
