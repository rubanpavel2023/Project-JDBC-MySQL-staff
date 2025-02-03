package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.controller.*;
import org.example.app.exeptions.OptionException;
import org.example.app.repository.*;

import org.example.app.utils.AppStarter;
import org.example.app.view.*;


public class AppService {

    public void createCompany() {
        CompanyCreateRepository repository = new CompanyCreateRepository();
        CompanyCreateService serviceCreate = new CompanyCreateService(repository);
        CompanyCreateView viewCreate = new CompanyCreateView();
        CompanyCreateController controller = new CompanyCreateController(serviceCreate, viewCreate);
        controller.createCompany();
    }

    public void createEmployee() {
        EmployeeCreateRepository repository = new EmployeeCreateRepository();
        EmployeeCreateService createService = new EmployeeCreateService(repository);
        EmployeeCreateView viewCreate = new EmployeeCreateView();
        EmployeeCreateController controller = new EmployeeCreateController(viewCreate, createService);
        controller.createEmployee();

    }

    public void updateCompany() {
        CompanyUpdateRepository repositoryUpdate = new CompanyUpdateRepository();
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyUpdateView viewUpdate = new CompanyUpdateView();
        CompanyReadService readService = new CompanyReadService(repositoryRead,viewRead);
        CompanyUpdateService serviceUpdate = new CompanyUpdateService(repositoryUpdate, readService);
        CompanyUpdateController controller = new CompanyUpdateController(serviceUpdate, viewUpdate);
        controller.updateCompany();

    }

    public void readCompany() {
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyReadService serviceRead = new CompanyReadService(repositoryRead,viewRead);
        CompanyReadController controller = new CompanyReadController(serviceRead, viewRead);
        controller.readCompany();

    }

    public void readEmployee() {
        EmployeeReadRepository repositoryRead = new EmployeeReadRepository();
        EmployeeReadView viewRead = new EmployeeReadView();
        EmployeeReadService serviceRead = new EmployeeReadService(repositoryRead,viewRead);
        EmployeeReadController controller = new EmployeeReadController(serviceRead, viewRead);
        controller.readEmployee();
    }

    public void deleteCompany() {
        CompanyDeleteRepository repositoryDelete = new CompanyDeleteRepository();
        CompanyReadRepository repositoryRead = new CompanyReadRepository();
        CompanyReadView viewRead = new CompanyReadView();
        CompanyReadService serviceRead = new CompanyReadService(repositoryRead,viewRead);
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
