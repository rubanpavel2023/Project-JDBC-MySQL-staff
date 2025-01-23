package org.example.app.controller;

import org.example.app.service.CompanyCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.CompanyCreateView;

public class CompanyCreateController {
    CompanyCreateService service;
    CompanyCreateView view;
    public CompanyCreateController(CompanyCreateService service,CompanyCreateView view ) {
        this.service = service;
        this.view = view;
    }

    public void createCompany() {
        view.getOutput(service.createCompany(view.getData()));
        AppStarter.startApp();
    }

}
