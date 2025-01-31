package org.example.app.service;

import org.example.app.entity.Company;
import org.example.app.repository.CompanyDeleteRepository;
import org.example.app.view.CompanySelectionView;

import java.util.List;

public class CompanyDeleteService {

    CompanyDeleteRepository repositoryDelete;
    CompanyReadService readService;
    Company choiceCompany;
    List<Company> choiceCompanies;

    public CompanyDeleteService(CompanyDeleteRepository repositoryDelete, CompanyReadService readService) {
        this.repositoryDelete = repositoryDelete;
        this.readService = readService;
    }

    public void deleteCompany (){
    choiceCompanies = readService.readCompanyForUpdateAndDelete();
    choiceCompany = CompanySelectionView.selectCompany(choiceCompanies);
    repositoryDelete.deleteCompany(choiceCompany);

    }
}
