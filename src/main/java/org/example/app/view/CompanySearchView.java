package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.utils.AppStarter;

import java.util.Scanner;

public class CompanySearchView {
    private static final Scanner scanner = new Scanner(System.in);
    public static char choiceCompleteList = '+';

    public static char selectCompanyInitial() {

        System.out.println("=> Enter the first letter of the company name " + "\n" +
                "=> To download the database of all companies, click '+' " + "\n"+
                "=> To return to the main menu, click '0' " + "\n");

        while (true) {
            String select = scanner.nextLine();
            if (select.length() == 1 && select.matches("[a-zA-Z+]")) {
                return select.charAt(0);
            }
            if (select.length() == 1 && select.equals("0")) {
                AppStarter.startApp();
            }
            else {
                System.out.println(Constants.INCORRECT_VALUE_MSG + "\n"
                        +"Please enter one letter character");
            }

        }
    }
}











