package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;

import java.util.List;
import java.util.Scanner;

public class EntitySearchView {
    private static final Scanner scanner = new Scanner(System.in);
    public static char choiceCompleteList = '+';

    public static char getInitialOfName() {
        while (true) {
            System.out.println("Select the entity ");
            System.out.println("Enter your choice (1 or 2): ");
            System.out.println(" - 1. Employee");
            System.out.println(" - 2. Company");

            String choice = scanner.nextLine();
            if (choice.length() == 1 && choice.equals("1")) {
                System.out.print("- Enter the first letter of the employee's last name " + "\n" +
                        "- To download a database of two employees, click +");
            }
            if (choice.length() == 1 && choice.equals("2")) {
                System.out.print("- Enter the first letter of the company name " + "\n" +
                        "- To download a database of two companies, click +");
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG);
                System.out.println();
                continue;
            }
            while (true) {
                String input = scanner.nextLine();
                if (input.length() == 1 && input.matches("[a-zA-Z0-9+-_]")) {
                    return input.charAt(0);
                } else {
                    System.out.println(Constants.INCORRECT_VALUE_MSG);
                    System.out.println("Invalid character entered or more " +
                            "than one character entered ");
                }
            }
        }
    }
}




