package org.example.app.entity;

import java.util.Objects;

public class Employee {
    private int idEmployee;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private int idCompany;
    private String companyType;

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getIdCompany() == employee.getIdCompany() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getPosition(), employee.getPosition()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getCompanyType(), employee.getCompanyType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPosition(), getEmail(), getIdCompany(), getCompanyType());
    }
}
