package org.example.app.controller;

import org.example.app.service.EmployeeDeleteService;
import org.example.app.utils.AppStarter;

public class EmployeeDeleteController {
    EmployeeDeleteService service;

    public EmployeeDeleteController(EmployeeDeleteService service) {
        this.service = service;
    }

    public void deleteEmployee() {
        service.deleteEmployee();
        AppStarter.startApp();
    }
}

