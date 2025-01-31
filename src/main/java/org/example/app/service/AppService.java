package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.controller.CompanyCreateController;
import org.example.app.controller.CompanyDeleteController;
import org.example.app.controller.CompanyReadController;
import org.example.app.controller.CompanyUpdateController;
import org.example.app.exeptions.OptionException;
import org.example.app.repository.CompanyCreateRepository;

import org.example.app.repository.CompanyDeleteRepository;
import org.example.app.repository.CompanyReadRepository;
import org.example.app.repository.CompanyUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.view.CompanyCreateView;

import org.example.app.view.CompanyReadView;
import org.example.app.view.CompanyUpdateView;


public class AppService {

    public void createCompany() {
        CompanyCreateRepository repository = new CompanyCreateRepository();
        CompanyCreateService serviceCreate = new CompanyCreateService(repository);
        CompanyCreateView viewCreate = new CompanyCreateView();
        CompanyCreateController controller = new CompanyCreateController(serviceCreate, viewCreate);
        controller.createCompany();
    }

    public void updateCompany() {
        CompanyUpdateRepository repositoryUpdate = new CompanyUpdateRepository();
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyUpdateView viewUpdate = new CompanyUpdateView();
        CompanyReadService readService = new CompanyReadService(repositoryRead, viewRead);
        CompanyUpdateService serviceUpdate = new CompanyUpdateService(repositoryUpdate, readService);
        CompanyUpdateController controller = new CompanyUpdateController(serviceUpdate, viewUpdate);
        controller.updateCompany();

    }

    public void readCompany() {
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyReadService serviceRead = new CompanyReadService(repositoryRead, viewRead);
        CompanyReadController controller = new CompanyReadController(serviceRead, viewRead);
        controller.readCompany();

    }

    public void deleteCompany() {
        CompanyDeleteRepository repositoryDelete = new CompanyDeleteRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadService serviceRead = new CompanyReadService(repositoryRead, viewRead);
        CompanyDeleteService serviceDelete = new CompanyDeleteService(repositoryDelete, serviceRead);
        CompanyDeleteController controller = new CompanyDeleteController(serviceDelete);
        controller.deleteCompany();
    }


    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException oe) {
                System.out.println(oe.getMessage());
                AppStarter.startApp();
            }
        }
    }


    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }

}
