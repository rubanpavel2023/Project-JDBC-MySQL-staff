package org.example.app.entity;

import java.util.Objects;

public class Company {

    private String idCompany;
    private String nameCompany;

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
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
        if (!(o instanceof Company company)) return false;
        return Objects.equals(getNameCompany(), company.getNameCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameCompany());
    }
}
