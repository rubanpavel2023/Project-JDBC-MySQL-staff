package org.example.app.view;

import org.example.app.entity.Company;

import java.util.List;
import java.util.Scanner;

public class EntitySearchView {
    private static final Scanner scanner = new Scanner(System.in);

    public static char getInitialOfName() {
        while (true) {
            System.out.println("Select the entity for which you want to enter the first letter:");
            System.out.println("1. Employee");
            System.out.println("2. Company");
            System.out.print("Enter your choice (1 or 2): ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the first letter of the employee's last name: ");
            } else if (choice.equals("2")) {
                System.out.print("Enter the first letter of the company name: ");
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            String input = scanner.nextLine();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter exactly one character.");
            }
        }
    }
}

