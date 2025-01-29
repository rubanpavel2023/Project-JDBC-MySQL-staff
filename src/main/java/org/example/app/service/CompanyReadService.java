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


    public String readCompany() {
        char choice = EntitySearchView.getInitialOfName();
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
            StringBuilder stringBuilder = new StringBuilder("Below is the list of companies based on your query:\n");
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




