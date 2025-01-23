package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;
import org.example.app.exeptions.CreateException;
import org.example.app.repository.CompanyCreateRepository;

import java.util.HashMap;
import java.util.Map;

public class CompanyCreateService {

    CompanyCreateRepository repository;

    public CompanyCreateService(CompanyCreateRepository repository) {
        this.repository = repository;
    }

    public String createCompany(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createCompany(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);


        return errors;
    }

    private Company convertData(String[] data) {
        Company company = new Company();
        company.setNameCompany(data[0]);

        return company;
    }
}


