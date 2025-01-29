package org.example.app.service;

import org.example.app.entity.Company;
import org.example.app.repository.CompanyReadRepository;
import org.example.app.view.EntitySearchView;

import java.util.List;

public class CompanyReadService {

    CompanyReadRepository repository;
    EntitySearchView searchView;

    public CompanyReadService(CompanyReadRepository repository, EntitySearchView searchView) {
        this.repository = repository;
        this.searchView = searchView;
    }

    public List<Company> getCompanyRead (CompanyReadRepository repository, EntitySearchView searchView ){

    }
}
