package org.example.app.controller;

import org.example.app.service.EmployeeReadService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeReadView;

public class EmployeeReadController {
    EmployeeReadService service;
    EmployeeReadView view;

    public EmployeeReadController(EmployeeReadService service, EmployeeReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployee() {
        view.getOutput(service.readEmployee());
        AppStarter.startApp();
    }


}
