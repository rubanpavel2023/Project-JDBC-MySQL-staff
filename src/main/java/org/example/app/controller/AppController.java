package org.example.app.controller;
 
 import org.example.app.constants.Constants;
 import org.example.app.service.AppService;
 import org.example.app.view.AppView;
 
 public class AppController {
     AppView view;
     AppService service;
 
     public AppController(AppView view, AppService service) {
         this.view = view;
         this.service = service;
     }
 
     public void runApp() {
         filterChoice(view.chooseOption());
     }
 
     private void filterChoice(int choice) {
         switch (choice) {
             case 1 -> service.createEmployee();
             case 2 -> service.createCompany();
             case 3 -> service.readEmployee();
             case 4 -> service.readCompany();
             case 5 -> service.updateEmployee();
             case 6 -> service.updateCompany();
             case 7 -> service.deleteEmployee();
             case 8 -> service.deleteCompany();
             case 0 -> view.getOutput(Constants.APP_CLOSE_MSG);
             default -> service.getNoSuchOption(choice);
 
         }
     }
 }
 
 