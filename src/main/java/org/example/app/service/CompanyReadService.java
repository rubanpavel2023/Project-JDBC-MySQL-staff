package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;
import org.example.app.repository.CompanyReadRepository;
import org.example.app.view.EntitySearchView;

import java.util.List;

public class CompanyReadService {

    CompanyReadRepository repository;

    public CompanyReadService(CompanyReadRepository repository) {
        this.repository = repository;
    }

    public List<Company> readCompanyFromUpdateAndDelete() {
        char choice = EntitySearchView.SelectAndSearchEntity();
        if (choice == EntitySearchView.choiceCompleteList) {
            List<Company> allCompanies = repository.readAllCompanies();
            return allCompanies;
        } else {
            List<Company> selectedCompanies = repository.readCompaniesByLastNameStartsWith(choice);
            return selectedCompanies;
        }
    }


    public String readCompany() {
        char choice = EntitySearchView.SelectAndSearchEntity();
        if (choice == EntitySearchView.choiceCompleteList) {
            List<Company> allCompanies = repository.readAllCompanies();
            return getCompanies(allCompanies);
        } else {
            List<Company> selectedCompanies = repository.readCompaniesByLastNameStartsWith(choice);
            return getCompanies(selectedCompanies);
        }
    }

    public String getCompanies(List<Company> companies) {
        if (companies.isEmpty()) {
            return Constants.NOTHING_FOUND_MSG;
        } else {
            System.out.println("Companies according to your request: \n");
            StringBuilder stringBuilder = new StringBuilder();
            companies.forEach(company -> stringBuilder.append("ID: ")
                    .append(company.getIdCompany())
                    .append(", Name Company: ")
                    .append(company.getNameCompany())
                    .append("\n")
            );
            return stringBuilder.toString();
        }
    }
}





