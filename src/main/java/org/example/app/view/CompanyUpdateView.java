package org.example.app.view;

import org.example.app.entity.Company;

import java.util.Scanner;

public class CompanyUpdateView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Company getUpdatedEmployee(Company originalCompany) {

        Company companyToUpdate = new Company();
        companyToUpdate.setIdCompany(originalCompany.getIdCompany());

        System.out.print("Enter new name company (current: " + originalCompany.getNameCompany() + "): ");
        String newNameCompany = scanner.nextLine();
        companyToUpdate.setNameCompany(newNameCompany.isEmpty() ? originalCompany.getNameCompany() : newNameCompany);
        System.out.println("New name company: " + companyToUpdate.getNameCompany());


        if (!isCompanyDataChanged(originalCompany, companyToUpdate)) {
            System.out.println("No changes detected. Company data remains unchanged.");
            return null;
        }

        return companyToUpdate;
    }

    private static boolean isCompanyDataChanged(Company original, Company updated) {
        return !original.getNameCompany().equals(updated.getNameCompany());
    }
}
