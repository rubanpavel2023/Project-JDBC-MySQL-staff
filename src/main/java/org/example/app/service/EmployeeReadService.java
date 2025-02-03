package org.example.app.service;

import org.example.app.entity.EmployeeDTO;
import org.example.app.repository.EmployeeReadRepository;
import org.example.app.view.EmployeeReadView;
import org.example.app.view.EntitySearchView;

import java.util.List;

public class EmployeeReadService {

    EmployeeReadRepository repository;
    EmployeeReadView view;


    public EmployeeReadService(EmployeeReadRepository repository, EmployeeReadView view) {
        this.repository = repository;
        this.view = view;
    }

    public String readEmployee() {
        char choice = EntitySearchView.SelectAndSearchEntity();
        if (choice == EntitySearchView.choiceCompleteList) {
            List<EmployeeDTO> allEmployees = repository.readAllEmployees();
            return view.getEmployeesInfo(allEmployees);
        } else {
            List<EmployeeDTO> selectedEmployees = repository.readEmployeesByLastNameStartsWith(choice);
            return view.getEmployeesInfo(selectedEmployees);
        }

    }
}
