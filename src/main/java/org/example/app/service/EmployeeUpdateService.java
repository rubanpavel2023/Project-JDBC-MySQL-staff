package org.example.app.service;
 
 import org.example.app.constants.Constants;
 import org.example.app.entity.Employee;
 import org.example.app.repository.CompanyReadRepository;
 import org.example.app.repository.EmployeeReadRepository;
 import org.example.app.repository.EmployeeUpdateRepository;
 import org.example.app.view.EmployeeSelectionView;
 import org.example.app.view.EmployeeUpdateView;
 
 import java.lang.reflect.Method;
 import java.util.ArrayList;
 import java.util.List;
 
 public class EmployeeUpdateService {
     EmployeeUpdateRepository repositoryUpdate;
     EmployeeReadService readService;
     Employee choiceEmployee;
     List<Employee> employees;
 
 
     public EmployeeUpdateService(EmployeeUpdateRepository repositoryUpdate, EmployeeReadService readService) {
         this.repositoryUpdate = repositoryUpdate;
         this.readService = readService;
     }
 
     public String updateEmployee() {
         employees = readService.readEmployeeForUpdateAndDelete();
         choiceEmployee = EmployeeSelectionView.selectEmployeeForUpdate(employees);
         if (choiceEmployee == null) {
             return Constants.NOTHING_FOUND_MSG;
         }
         Employee updatedEmployee = getUpdateEmployee(choiceEmployee);
         if (updatedEmployee == null) {
             return Constants.SAME_NAME_ENTERED_MSG;
         } else return repositoryUpdate.updateEmployee(updatedEmployee);
 
     }
 
     private Employee getUpdateEmployee(Employee employeeToUpdate) {
         String[] originalData = {employeeToUpdate.getFirstName(), employeeToUpdate.getLastName(),
                 employeeToUpdate.getPosition(), employeeToUpdate.getEmail(), Integer.toString(employeeToUpdate.getIdCompany())};
         String[] data = EmployeeUpdateView.getNewDataEmployee();
         String[] fields = {"firstName", "lastName", "position", "email", "idCompany"};
         try {
             for (int i = 0; i < data.length - 1 && i < fields.length - 1; i++) {
                 String nameMethod = "set" + Character.toUpperCase(fields[i].charAt(0)) +
                         fields[i].substring(1);
                 Method method = Employee.class.getMethod(nameMethod, String.class);
                 method.invoke(employeeToUpdate, data[i]);
             }
             String nameMethod = "set" + Character.toUpperCase(fields[4].charAt(0)) +
                     fields[4].substring(1);
             Method methodForID = Employee.class.getMethod(nameMethod, int.class);
             methodForID.invoke(employeeToUpdate, Integer.parseInt(data[4]));
 
             if (originalData[0].equals(employeeToUpdate.getFirstName()) &&
                     originalData[1].equals(employeeToUpdate.getLastName()) &&
                     originalData[2].equals(employeeToUpdate.getPosition()) &&
                     originalData[3].equals(employeeToUpdate.getEmail()) &&
                     originalData[4].equals(Integer.toString(employeeToUpdate.getIdCompany()))) {
                 //Integer.parseInt(originalData[4]) == employeeToUpdate.getIdCompany()) {
                 return null;
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         return employeeToUpdate;
     }
 }
 
 
 
 /*    public static boolean isCompanyIdExists(int idCompany) {
         CompanyReadRepository repository = new CompanyReadRepository();
         List<Integer> idCompanies = new ArrayList();
         idCompanies = repository.readIdCompanies();
         if (idCompanies.contains(idCompany)) {
             return true;
         } else return false;
     }*/
 
 
 
 
 