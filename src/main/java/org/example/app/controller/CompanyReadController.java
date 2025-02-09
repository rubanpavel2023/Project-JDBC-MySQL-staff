package org.example.app.controller;

import org.example.app.service.CompanyReadService;
import org.example.app.utils.AppStarter;
import org.example.app.view.CompanyReadView;

public class CompanyReadController {

    CompanyReadService service;
    CompanyReadView view;


    public CompanyReadController(CompanyReadService service, CompanyReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readCompany() {
        view.getOutput(service.readCompany());
        AppStarter.startApp();

    }
}

