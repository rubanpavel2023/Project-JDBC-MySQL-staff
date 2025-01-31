package org.example.app.controller;

import org.example.app.service.CompanyDeleteService;
import org.example.app.utils.AppStarter;

public class CompanyDeleteController {

    CompanyDeleteService service;

    public CompanyDeleteController(CompanyDeleteService service) {
        this.service = service;
    }

    public void deleteCompany() {
        service.deleteCompany();
        AppStarter.startApp();

    }




}
