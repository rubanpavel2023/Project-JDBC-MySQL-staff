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

        if (data[0].isEmpty()) {
            errors.put("Name", Constants.INPUT_REQ_MSG);
        }
        /*if (!isAlphaNumeric(data[0])) {
            errors.put("Name", Constants.ALPHANUMERIC_VALUES_ONLY_MSG);
        }*/

        return errors;
    }

    /*private boolean isAlphaNumeric(String date) {
        return date.matches("[a-zA-Z0-9]+");
    }*/

    private Company convertData(String[] data) {
        Company company = new Company();
        company.setNameCompany(data[0]);

        return company;
    }
}


