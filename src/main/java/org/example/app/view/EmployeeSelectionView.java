package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;
import org.example.app.entity.EmployeeDTO;
import org.example.app.utils.AppStarter;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;


public class EmployeeSelectionView {
    private static int i;
    private static final Scanner scanner = new Scanner(System.in);


    public static EmployeeDTO selectEmployeeForUpdate(List<EmployeeDTO> employees) {
        if (employees.isEmpty()) {
            return null;
        }
        if (employees.size() == 1) {
            System.out.println("<Employee according to your request: > \n" +
                    employees.get(0).getNameCompany());
            return employees.get(0);
        }
        System.out.println("<Companies according to your request: > \n");
        for (int i = 0; i < employees.size(); i++) {
            EmployeeDTO selectedEmployee = employees.get(i);
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

    public static Company selectCompanyForDelete(List<Company> companies) {
        if (companies.isEmpty()) {
            return null;
        }
        if (companies.size() == 1) {
            System.out.println("<Company according to your request: > \n" +
                    companies.get(0).getNameCompany() + "\n" + "To confirm deletion press '1', " +
                    "to cancel deletion press '2' ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                return companies.get(0);
            } else AppStarter.startApp();
        }

        System.out.println("<Companies according to your request: > \n");
        for (i = 0; i < companies.size(); i++) {
            Company selectedCompany = companies.get(i);
            System.out.println((i + 1) +
                    ") Name company: " + selectedCompany.getNameCompany());
        }

        System.out.println("\n" + "=> Enter the number of the company " +
                "from the list to proceed with actions: ");
        while (true) {
            try {
                int choiceCompany = scanner.nextInt();
                if (choiceCompany > 0 && choiceCompany <= i) {
                    scanner.nextLine();
                    return companies.get(choiceCompany - 1);
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
