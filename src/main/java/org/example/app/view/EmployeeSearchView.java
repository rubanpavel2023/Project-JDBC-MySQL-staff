package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.utils.AppStarter;

import java.util.Scanner;

public class EmployeeSearchView {
    public static char choiceCompleteList = '+';

    public static char selectEmployeeInitial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=> Enter the first letter of the employee name " + "\n" +
                "=> To download the database of all employees, click '+' " + "\n" +
                "=> To return to the main menu, click '0' " + "\n");

        while (true) {
            String select = scanner.nextLine();
            if (select.length() == 1 && select.matches(Constants.SEARCH_ENTITY_REGEX)) {
                return select.charAt(0);
            }
            if (select.length() == 1 && select.equals("0")) {
                AppStarter.startApp();
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG + "\n"
                        + "Please enter one uppercase letter ");
            }

        }
    }
}

