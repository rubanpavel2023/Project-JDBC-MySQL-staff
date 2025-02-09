package org.example.app.service;
 
 import org.example.app.constants.Constants;
 import org.example.app.entity.Employee;
 import org.example.app.repository.EmployeeDeleteRepository;
 import org.example.app.view.EmployeeSelectionView;
 
 import java.util.List;
 
 public class EmployeeDeleteService {
     EmployeeDeleteRepository repositoryDelete;
     EmployeeReadService readService;
     Employee choiceEmployee;
     List<Employee> choiceEmployees;
 
     public EmployeeDeleteService(EmployeeDeleteRepository repositoryDelete, EmployeeReadService readService) {
         this.repositoryDelete = repositoryDelete;
         this.readService = readService;
     }
 
     public void deleteEmployee() {
         choiceEmployees = readService.readEmployeeForUpdateAndDelete();
         choiceEmployee = EmployeeSelectionView.selectEmployeeForDelete(choiceEmployees);
         if (choiceEmployee == null) {
             System.out.println(Constants.NOTHING_FOUND_MSG);
         } else
             repositoryDelete.deleteEmployeeByLastName(choiceEmployee);
 
     }
 
 }
 
 