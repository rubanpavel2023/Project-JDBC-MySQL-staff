package org.example.app.view;

import org.example.app.constants.Constants;


import java.util.Scanner;

public class EntitySearchView {
    private static final Scanner scanner = new Scanner(System.in);
    public static char choiceCompleteList = '+';

    public static char SelectAndSearchEntity() {
        while (true) {
            System.out.println("Select the entity " + "\n" +
                    "Enter your choice (1 or 2): " + "\n" +
                    " - 1. Employee" + "\n" +
                    " - 2. Company");

            String choice = scanner.nextLine();
            if (choice.length() == 1 && choice.equals("1")) {
                System.out.print("=> Enter the first letter of the employee's last name " + "\n" +
                        "=> To download a database of two employees, click '+' " + "\n");
            }
            if (choice.length() == 1 && choice.equals("2")) {
                System.out.print("=> Enter the first letter of the company name " + "\n" +
                        "=> To download a database of two companies, click '+' " + "\n");
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +  "\n");
                continue;
            }
            while (true) {
                String select = scanner.nextLine();
                if (select.length() == 1 && select.matches("[a-zA-Z0-9+-_]")) {
                    return select.charAt(0);
                } else {
                    System.out.println(Constants.INCORRECT_VALUE_MSG);
                    System.out.println("! Invalid character entered or more " +
                            "than one character entered ");
                }
            }
        }
    }
}




