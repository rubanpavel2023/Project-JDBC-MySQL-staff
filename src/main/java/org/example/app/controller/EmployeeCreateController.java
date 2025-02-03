package org.example.app.controller;

import org.example.app.service.AppService;
import org.example.app.service.EmployeeCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EmployeeCreateView;

public class EmployeeCreateController {
    EmployeeCreateView view;
    EmployeeCreateService service;

    public EmployeeCreateController(EmployeeCreateView view, EmployeeCreateService service) {
        this.view = view;
        this.service = service;
    }
    public void createEmployee (){
        view.getOutput(service.createEmployee(view.getData()));
        AppStarter.startApp();
    }
}
