package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;
import org.example.app.repository.CompanyUpdateRepository;
import org.example.app.view.CompanySelectionView;
import org.example.app.view.CompanyUpdateView;

import java.lang.reflect.Method;
import java.util.List;


public class CompanyUpdateService {
    CompanyUpdateRepository repositoryUpdate;
    CompanyReadService readService;
    Company choiceCompany;
    List<Company> companies;


    public CompanyUpdateService(CompanyUpdateRepository repositoryUpdate, CompanyReadService readService) {
        this.repositoryUpdate = repositoryUpdate;
        this.readService = readService;
    }

    public String updateCompany() {
        companies = readService.readCompanyForUpdateAndDelete();
        choiceCompany = CompanySelectionView.selectCompanyForUpdate(companies);
        if (choiceCompany == null) {
            return Constants.NOTHING_FOUND_MSG;
        }
        Company updatedCompany = getUpdateCompany(choiceCompany);
        if (updatedCompany == null) {
            return Constants.SAME_NAME_ENTERED_MSG;
        } else return repositoryUpdate.updateCompany(updatedCompany);

    }


    private Company getUpdateCompany(Company companyToUpdate) {
        String[] originalData = {companyToUpdate.getNameCompany()};
        String[] data = CompanyUpdateView.getNewDataCompany();
        String[] fields = {"nameCompany"};
        try {
            for (int i = 0; i < data.length && i < fields.length; i++) {
                String nameMethod = "set" +
                        Character.toUpperCase(fields[i].charAt(0)) +
                        fields[i].substring(1);
                Method method = Company.class.getMethod(nameMethod, String.class);
                method.invoke(companyToUpdate, data[i]);
            }

            if (originalData[0].equals(companyToUpdate.getNameCompany())) {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return companyToUpdate;
    }

}



