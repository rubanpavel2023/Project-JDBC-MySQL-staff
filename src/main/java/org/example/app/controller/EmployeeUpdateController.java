package org.example.app.controller;

import org.example.app.service.EmployeeUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeUpdateView;

public class EmployeeUpdateController {
    EmployeeUpdateService service;
    EmployeeUpdateView view;


    public EmployeeUpdateController(EmployeeUpdateService service, EmployeeUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateEmployee() {
        view.getOutput(service.updateEmployee());
        AppStarter.startApp();

    }
}

