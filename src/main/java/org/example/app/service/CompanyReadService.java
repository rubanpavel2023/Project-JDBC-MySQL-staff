package org.example.app.service;

import org.example.app.entity.Company;
import org.example.app.repository.CompanyReadRepository;
import org.example.app.view.CompanyReadView;
import org.example.app.view.EntitySearchView;

import java.util.List;

public class CompanyReadService {

    CompanyReadRepository repository;
    CompanyReadView view;

    public CompanyReadService(CompanyReadRepository repository, CompanyReadView view) {
        this.repository = repository;
        this.view = view;
    }

    public List<Company> readCompanyForUpdateAndDelete() {
        char choice = EntitySearchView.SelectAndSearchEntity();
        if (choice == EntitySearchView.choiceCompleteList) {
            List<Company> allCompanies = repository.readAllCompanies();
            return allCompanies;
        } else {
            List<Company> choiceCompanies = repository.readCompaniesByLastNameStartsWith(choice);
            return choiceCompanies;
        }
    }


    public String readCompany() {
        char choice = EntitySearchView.SelectAndSearchEntity();
        if (choice == EntitySearchView.choiceCompleteList) {
            List<Company> allCompanies = repository.readAllCompanies();
            return view.getCompanies(allCompanies);
        } else {
            List<Company> selectedCompanies = repository.readCompaniesByLastNameStartsWith(choice);
            return view.getCompanies(selectedCompanies);
        }

    }

}





