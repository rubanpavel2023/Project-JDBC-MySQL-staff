package org.example.app.view;

import org.example.app.constants.Constants;

import java.util.Scanner;

public class CompanyUpdateView {


    public static String[] getNewDataCompany() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "=> Enter new name company: ");
            String name = scanner.nextLine().trim();

            if (name.matches(Constants.NAME_COMPANY_REGEX)) {
                return new String[]{name};
            } else {
                System.out.println(Constants.WRONG_NAME_COMPANY_MSG);
            }
        }
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
