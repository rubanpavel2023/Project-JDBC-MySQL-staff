package org.example.app.view;

import org.example.app.entity.Company;

import java.util.Scanner;

public class CompanyUpdateView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getData() {

        System.out.print("Enter new name company: ");
        String newNameCompany = scanner.nextLine();
        return new String[]{newNameCompany};
    }
}
