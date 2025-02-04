package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.entity.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;


public class EmployeeSelectionView {
    private static int i;
    private static Scanner scanner = new Scanner(System.in);


    public static Employee selectEmployeeForUpdate(List<Employee> employees) {
        if (employees.isEmpty()) {
            return null;
        }
        if (employees.size() == 1) {
            System.out.println("<Employee according to your request: > \n" +
                    employees.get(0).getNameCompany());
            return employees.get(0);
        }
        System.out.println("<Employees according to your request: > \n");
        for (i = 0; i < employees.size(); i++) {
            Employee selectedEmployee = employees.get(i);
            System.out.println((i + 1) +
                    ") First Name: " + selectedEmployee.getFirstName() +
                    ", Last Name: " + selectedEmployee.getLastName() +
                    ", Position: " + selectedEmployee.getPosition() +
                    ", Email: " + selectedEmployee.getEmail() +
                    ", Company ID: " + selectedEmployee.getIdCompany() +
                    ", Company Name: " + selectedEmployee.getNameCompany());
        }

        System.out.println("\n" + "=> Enter the number of the Employee " +
                "from the list to proceed with actions: ");
        while (true) {
            try {
                int choiceEmployee = scanner.nextInt();
                if (choiceEmployee > 0 && choiceEmployee <= i) {
                    scanner.nextLine();
                    return employees.get(choiceEmployee - 1);
                } else {
                    System.out.println("\n" + Constants.INCORRECT_VALUE_MSG);
                }
            } catch (InputMismatchException ime) {
                System.out.println("\n" + Constants.INCORRECT_VALUE_MSG);
                scanner.nextLine();
            }

        }
    }


}
