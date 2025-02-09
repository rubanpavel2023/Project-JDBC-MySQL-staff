package org.example.app.service;
 
 import org.example.app.entity.Employee;
 import org.example.app.repository.EmployeeReadRepository;
 import org.example.app.view.EmployeeReadView;
 import org.example.app.view.EmployeeSearchView;
 
 import java.util.List;
 
 public class EmployeeReadService {
 
     EmployeeReadRepository repository;
     EmployeeReadView view;
 
 
     public EmployeeReadService(EmployeeReadRepository repository, EmployeeReadView view) {
         this.repository = repository;
         this.view = view;
     }
 
     public List<Employee> readEmployeeForUpdateAndDelete() {
         char choice = EmployeeSearchView.selectEmployeeInitial();
         if (choice == EmployeeSearchView.choiceCompleteList) {
             List<Employee> allEmployees = repository.readAllEmployees();
             return allEmployees;
         } else {
             List<Employee> choiceEmployees = repository.readEmployeesByLastNameStartsWith(choice);
             return choiceEmployees;
         }
     }
 
     public String readEmployee() {
         char choice = EmployeeSearchView.selectEmployeeInitial();
         if (choice == EmployeeSearchView.choiceCompleteList) {
             List<Employee> allEmployees = repository.readAllEmployees();
             return view.getEmployeesInfo(allEmployees);
         } else {
             List<Employee> selectedEmployees = repository.readEmployeesByLastNameStartsWith(choice);
             return view.getEmployeesInfo(selectedEmployees);
         }
 
     }
 }
 
 