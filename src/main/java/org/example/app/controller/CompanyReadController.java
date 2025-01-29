package org.example.app.controller;

import org.example.app.service.AppService;
import org.example.app.service.CompanyReadService;
import org.example.app.view.CompanyReadView;

public class CompanyReadController {

    CompanyReadService service;
    CompanyReadView view;

    public CompanyReadController(CompanyReadService service, CompanyReadView view) {
        this.service = service;
        this.view = view;
    }

    public String readCompany (){
        //service.readCompany();
        return "";
    }
}
