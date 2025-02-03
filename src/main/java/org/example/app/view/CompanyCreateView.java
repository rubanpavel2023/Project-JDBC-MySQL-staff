package org.example.app.view;

import org.example.app.constants.Constants;

import java.util.Scanner;

public class CompanyCreateView {


    public String[] getData(){

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "=> Enter company name: ");
            String name = scanner.nextLine().trim();

            if (name.matches(Constants.NAME_COMPANY)) {
                return new String[]{name};
            } else {
                System.out.println(Constants.WRONG_NAME_MSG);
            }
        }

    }


    public void getOutput(String output) {
        System.out.println(output);
    }
}


