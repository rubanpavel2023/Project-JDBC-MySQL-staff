package org.example.app.controller;

import org.example.app.service.CompanyUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.view.EntitySearchView;

public class CompanyUpdateController {

    CompanyUpdateService service;
    EntitySearchView view;


    public CompanyUpdateController(CompanyUpdateService service, EntitySearchView view) {
        this.service = service;
        this.view = view;
    }

    public void updateCompany() {
        service.getUpdateCompany(EntitySearchView.getInitialOfName());
        AppStarter.startApp();

    }
}
