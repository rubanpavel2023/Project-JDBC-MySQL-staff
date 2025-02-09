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
                
                ___________ MENU _______________________
                    CREATE        UPDATE
                1 - Employee      5 - Employee
                2 - Company       6 - Company
                
                    READ          DELETE
                3 - Employee      7 - Employee
                4 - Company       8 - Company
                
                0 - Close the App.
                ________________________________________
                """);

    }

    public void getOutput(String output) {
        System.out.println(output);
        scanner.close();
        System.exit(0);
    }

}

