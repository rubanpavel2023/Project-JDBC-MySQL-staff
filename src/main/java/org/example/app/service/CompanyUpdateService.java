package org.example.app.service;

import org.example.app.entity.Company;
import org.example.app.repository.CompanyReadRepository;
import org.example.app.repository.CompanyUpdateRepository;
import org.example.app.view.CompanySelectionView;
import org.example.app.view.CompanyUpdateView;

import java.util.List;


public class CompanyUpdateService {
    CompanyUpdateRepository repositoryUpdate;
    CompanyReadRepository repositoryRead;
    Company choiceCompany;


    public CompanyUpdateService(CompanyUpdateRepository repositoryUpdate, CompanyReadRepository repositoryRead) {
        this.repositoryUpdate = repositoryUpdate;
        this.repositoryRead = repositoryRead;
    }

    public boolean getUpdateCompany(char firstLetter) {
        List<Company> companies =
                repositoryRead.readCompaniesByLastNameStartsWith(firstLetter);
        choiceCompany = CompanySelectionView.selectCompany(companies);
        return repositoryUpdate.updateCompany(updateData(choiceCompany));

    }

    private Company updateData(Company companyToUpdate) {
        String[] data = CompanyUpdateView.getData();
        companyToUpdate.setNameCompany(data[0]);
        return companyToUpdate;
    }
}
