package org.example.app.view;

import org.example.app.entity.Employee;
import org.example.app.constants.Constants;

import java.util.List;

public class EmployeeReadView {
    public void getOutput(String output) {
        System.out.println(output);
    }

    public String getEmployeesInfo(List<Employee> employees) {
        if (employees.isEmpty()) {
            return Constants.NOTHING_FOUND_MSG;
        } else
            System.out.println("Below is a list of employees that match your request:");
        StringBuilder stringBuilder = new StringBuilder();
        employees.forEach(employee -> stringBuilder.
                append("ID: " + employee.getIdEmployee()).
                append(", First Name: " + employee.getFirstName()).
                append(", Last Name: " + employee.getLastName()).
                append(", Position: " + employee.getPosition()).
                append(", Email: " + employee.getEmail()).
                append(", Company ID: " + employee.getIdCompany()).
                append(", Company name: " + employee.getNameCompany()).
                append("\n"));
        return stringBuilder.toString();

    }
}
