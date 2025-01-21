package org.example.app.view;

import org.example.app.entity.Company;
import java.util.Scanner;

public class CompanyCreateView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Company getCompanyDetails() {
        System.out.println("Creating a new company");
        System.out.println("Enter company name: ");
        String nameCompany = scanner.nextLine();
        Company companyToCreate = new Company();
        companyToCreate.setNameCompany(nameCompany);
        return companyToCreate;
    }
}

