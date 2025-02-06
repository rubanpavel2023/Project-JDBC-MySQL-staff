package org.example.app.view;

import org.example.app.constants.Constants;
import org.example.app.entity.Company;

import java.util.List;

public class CompanyReadView {
    public void getOutput(String output) {
        System.out.println(output);
    }

    public String getCompaniesInfo(List<Company> companies) {
        if (companies.isEmpty()) {
            return Constants.NOTHING_FOUND_MSG;
        } else {
            System.out.println("<Companies according to your request: > \n");
            StringBuilder stringBuilder = new StringBuilder();
            companies.forEach(company -> stringBuilder.append("ID: ")
                    .append(company.getIdCompany())
                    .append(", Name Company: ")
                    .append(company.getNameCompany())
                    .append("\n")
            );
            return stringBuilder.toString();
        }
    }

    public static void getCompaniesInfoForSelect(List<Company> companies) {
        StringBuilder stringBuilder = new StringBuilder();
        companies.forEach(company -> stringBuilder.append("ID: ")
                .append(company.getIdCompany())
                .append(", Name Company: ")
                .append(company.getNameCompany())
                .append("\n"));
        System.out.println(stringBuilder);
    }

}
