package org.example.app.view;

import org.example.app.constants.Constants;

import java.util.Scanner;

public class CompanyCreateView {


    public String[] getData(){

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + "=> Enter company name: ");
            String name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Z0-9-]+")) {
                return new String[]{name};
            } else {
                System.out.println(Constants.INCORRECT_VALUE_MSG +
                        "\n" + "Invalid characters");

            }
        }
    }


    public void getOutput(String output) {
        System.out.println(output);
    }
}



