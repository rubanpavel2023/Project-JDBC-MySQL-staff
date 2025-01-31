package org.example.app.view;

import java.util.Scanner;

public class CompanyUpdateView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getNewData() {

        System.out.print("=> Enter new name company: ");
        String newNameCompany = scanner.nextLine();
        return new String[]{newNameCompany};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
