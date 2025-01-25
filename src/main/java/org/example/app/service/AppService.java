package org.example.app.service;

import org.example.app.constants.Constants;
import org.example.app.controller.CompanyCreateController;
import org.example.app.controller.CompanyUpdateController;
import org.example.app.exeptions.OptionException;
import org.example.app.repository.CompanyCreateRepository;

import org.example.app.repository.CompanyReadRepository;
import org.example.app.repository.CompanyUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.view.CompanyCreateView;

import org.example.app.view.CompanyUpdateView;
import org.example.app.view.EntitySearchView;


public class AppService {

    public void createCompany() {
        CompanyCreateRepository repository = new CompanyCreateRepository();
        CompanyCreateService service = new CompanyCreateService(repository);
        CompanyCreateView view = new CompanyCreateView();
        CompanyCreateController controller = new CompanyCreateController(service, view);
        controller.createCompany();
    }

    public void updateCompany() {
        EntitySearchView search = new EntitySearchView();
        CompanyReadRepository repositoryRead = new CompanyReadRepository(search);
        CompanyUpdateRepository repositoryUpdate = new CompanyUpdateRepository();
        CompanyUpdateService service = new CompanyUpdateService(repositoryUpdate, repositoryRead);
        CompanyUpdateView view = new CompanyUpdateView();
        CompanyUpdateController controller = new CompanyUpdateController(service,view);
        controller.updateCompany();

    }


    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
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
