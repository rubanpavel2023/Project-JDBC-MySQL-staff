package org.example.app.view;

import java.util.Scanner;

public class CompanySearchView {
    private static final Scanner scanner = new Scanner(System.in);

    public static char getInitialOfNameCompany() {
        while (true) {
            System.out.print("Enter the first letter of the name company: ");
            String input = scanner.nextLine();
            if (input.length() == 1) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter exactly one character");
            }
        }
    }
}
