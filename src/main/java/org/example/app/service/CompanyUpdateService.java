package org.example.app.service;

import org.example.app.constants.Constants;
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
    List<Company> companies;


    public CompanyUpdateService(CompanyUpdateRepository repositoryUpdate, CompanyReadRepository repositoryRead) {
        this.repositoryUpdate = repositoryUpdate;
        this.repositoryRead = repositoryRead;
    }

    public String getUpdateCompany(char firstLetter) {
        List<Company> companies =
                repositoryRead.readCompaniesByLastNameStartsWith(firstLetter);
        choiceCompany = CompanySelectionView.selectCompany(companies);
        repositoryUpdate.updateCompany(updateData(choiceCompany));
        return Constants.DATA_COMPANY_UPDATE_MSG;

    }

    private Company updateData(Company companyToUpdate) {
        String[] data = CompanyUpdateView.getData();
        companyToUpdate.setNameCompany(data[0]);
        return companyToUpdate;
    }
}
