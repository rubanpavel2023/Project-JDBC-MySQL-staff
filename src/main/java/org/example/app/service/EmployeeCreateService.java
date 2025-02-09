package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.entity.Employee;
import org.example.app.exeptions.CreateException;
import org.example.app.repository.EmployeeCreateRepository;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCreateService {

    EmployeeCreateRepository repository;

    public EmployeeCreateService(EmployeeCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }

        return repository.createEmployee(convertData(data));
    }


    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty()) {
            errors.put("First name ", Constants.INPUT_REQ_MSG);
        }
        if (data[1].isEmpty()) {
            errors.put("Last name ", Constants.INPUT_REQ_MSG);
        }
        if (data[2].isEmpty()) {
            errors.put("Position ", Constants.INPUT_REQ_MSG);
        }
        if (data[3].isEmpty()) {
            errors.put("Email ", Constants.INPUT_REQ_MSG);
        }
        if (data[4].isEmpty()) {
            errors.put("ID Company", Constants.INPUT_REQ_MSG);
        }

        return errors;
    }


    private Employee convertData(String[] data) {
        Employee employee = new Employee();
        employee.setFirstName(data[0]);
        employee.setLastName(data[1]);
        employee.setPosition(data[2]);
        employee.setEmail(data[3]);
        int idCompany = Integer.parseInt(data[4]);
        employee.setIdCompany(idCompany);


        return employee;
    }

}


