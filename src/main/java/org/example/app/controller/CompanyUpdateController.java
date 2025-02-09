package org.example.app.controller;

import org.example.app.service.CompanyUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.CompanyUpdateView;


public class CompanyUpdateController {

    CompanyUpdateService service;
    CompanyUpdateView view;


    public CompanyUpdateController(CompanyUpdateService service, CompanyUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateCompany() {
        view.getOutput(service.updateCompany());
        AppStarter.startApp();

    }
}

