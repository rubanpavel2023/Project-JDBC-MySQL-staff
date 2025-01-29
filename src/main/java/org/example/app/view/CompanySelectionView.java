package org.example.app.view;

import org.example.app.entity.Company;
import org.example.app.repository.CompanyReadRepository;

import java.util.List;
import java.util.Scanner;

public class CompanySelectionView {
    CompanyReadRepository repositoryRead;

    public CompanySelectionView(CompanyReadRepository readRepository) {
        this.repositoryRead = readRepository;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static Company selectCompany(List<Company> companies) {
        if (companies.isEmpty()) {
            return null;
        }
        if (companies.size() == 1) {
            System.out.println("Сompany according to your request: " + "\n" +
                    companies.get(0).getNameCompany());
            return companies.get(0);
        }
        System.out.println("Select a company from the list:");
        for (int i = 0; i < companies.size(); i++) {
            Company selectedCompany = companies.get(i);
            System.out.println((i + 1) +
                    ") Name company: " + selectedCompany.getNameCompany());
        }
        System.out.print("Enter the number of the company " +
                "from the list to proceed with actions: ");
        int choiceCompany = scanner.nextInt();
        scanner.nextLine();
        return companies.get(choiceCompany - 1);
    }
}