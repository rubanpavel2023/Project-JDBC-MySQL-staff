package org.example.app.view;

import org.example.app.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeUpdateView {

    private static Scanner scanner = new Scanner(System.in);

    public static String[] getNewDataEmployee() {
        List<String> list = new ArrayList<>();
        System.out.println("=> Enter new firstName employee: ");
        while (true) {
            String firstName = scanner.nextLine();
            if (firstName.matches(Constants.FIRST_AND_LASTNAME_EMPLOYEE_REGEX)) {
                list.add(firstName);
                break;
            } else {
                System.out.println(Constants.WRONG_NAME_MSG);
            }
        }

        System.out.println("=> Enter new lastName employee: ");
        while (true) {
            String lastName = scanner.nextLine();
            if (lastName.matches(Constants.FIRST_AND_LASTNAME_EMPLOYEE_REGEX)) {
                list.add(lastName);
                break;
            } else {
                System.out.println(Constants.WRONG_NAME_MSG);
            }
        }


        System.out.println("=> Enter new position employee: ");
        while (true) {
            String position = scanner.nextLine();
            if (position.matches(Constants.POSITION_EMPLOYEE_REGEX)) {
                list.add(position);
                break;
            } else {
                System.out.println(Constants.WRONG_NAME_MSG);
            }
        }


        System.out.println("=> Enter new email employee: " + "\n" +
                "If email address is missing, click '0' ");
        while (true) {
            String email = scanner.nextLine();
            if (email.matches(Constants.EMAIL_REGEX)) {
                list.add(email);
                break;
            }
            ;
            if (email.equals("0")) {
                list.add(Constants.EMAIL_NOT_FOUND_MSG);
                break;
            } else {
                System.out.println(Constants.WRONG_EMAIL_MSG);
            }
        }

        System.out.println("=> Enter the new company ID assigned to the employee: ");
        while (true) {
            String idCompany = scanner.nextLine();
            if (idCompany.matches(Constants.ID_COMPANY_REGEX)) {
                list.add(idCompany);
                break;
            } else {
                System.out.println(Constants.WRONG_ID_MSG);
            }
        }
        return list.toArray(new String[0]);


    }

    public void getOutput(String output) {
        System.out.println(output);
    }


}





