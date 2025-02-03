package org.example.app.entity;

import java.util.Objects;

public class EmployeeDTO {
    private int idEmployee;
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private int idCompany;
    private String nameCompany;


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

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDTO that)) return false;
        return getIdEmployee() == that.getIdEmployee() && getIdCompany() == that.getIdCompany() && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getPosition(), that.getPosition()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getNameCompany(), that.getNameCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdEmployee(), getFirstName(), getLastName(), getPosition(), getEmail(), getIdCompany(), getNameCompany());
    }
}

