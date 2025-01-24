package org.example.app.view;

import java.util.Scanner;

public class CompanyCreateView {


    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter company name: ");
        String name = scanner.nextLine().trim();

        return new String[]{name};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }







   /* private static final Scanner scanner = new Scanner(System.in);

    public static Company getCompanyDetails() {
        System.out.println("Creating a new company");
        System.out.println("Enter company name: ");
        String nameCompany = scanner.nextLine();
        Company companyToCreate = new Company();
        companyToCreate.setNameCompany(nameCompany);
        return companyToCreate;
    }*/
}

