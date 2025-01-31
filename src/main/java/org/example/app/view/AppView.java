package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.utils.AppStarter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                
                ______ MENU ___________
                1 - Create Employee
                2 - Create Company
                3 - Read Employee
                4 - Read Company
                5 - Update Employee
                6 - Update Company
                7 - Delete Employee
                8 - Delete Company
                0 - Close the App.
                _______________________
                """);

    }

    public void getOutput(String output) {
        System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}