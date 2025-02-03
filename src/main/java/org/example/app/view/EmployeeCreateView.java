package org.example.app.view;

import org.example.app.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeCreateView {
    private static final Scanner scanner = new Scanner(System.in);

    public String[] getData() {
        List<String> list = new ArrayList<>();
        System.out.println("=> Enter firstName employee: ");
        while (true) {
            String firstName = scanner.nextLine();
            if (firstName.matches("[a-zA-Z]+")) {
                list.add(firstName);
                break;
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Please enter only alphabetic characters");
            }
        }

        System.out.println("=> Enter lastName employee: ");
        while (true) {
            String lastName = scanner.nextLine();
            if (lastName.matches("[a-zA-Z]+")) {
                list.add(lastName);
                break;
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Please enter only alphabetic characters");
            }
        }


        System.out.println("=> Enter position employee: ");
        while (true) {
            String position = scanner.nextLine();
            if (position.matches("[a-zA-Z]+")) {
                list.add(position);
                break;
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Please enter only alphabetic characters");
            }
        }


        System.out.println("=> Enter email employee: ");
        while (true) {
            String email = scanner.nextLine();
            if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                list.add(email);
                break;
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Invalid characters");
            }
        }

        System.out.println("=> Enter the company ID assigned to the employee: ");
        while (true) {
            String idCompany = scanner.nextLine();
            if (idCompany.matches("[0-9]+")) {
                list.add(idCompany);
                break;
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Only numeric values are allowed to be entered.");
            }
        }
        return list.toArray(new String[0]);


    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}



