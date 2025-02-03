package org.example.app.constants;

public class Constants {
    public static final String TABLE_EMPLOYEES = "employees";
    public static final String TABLE_COMPANIES = "companies";
    public static final String DATA_EMPLOYEE_INSERT_MSG = "<Employee created successfully>";
    public static final String DATA_COMPANY_INSERT_MSG = "<Company created successfully>";
    public static final String DATA_COMPANY_UPDATE_MSG = "<Data updated successfully>";
    public static final String SAME_NAME_ENTERED_MSG = "No changes found," + "\n" + "No database update required";
    public static final String INCORRECT_VALUE_MSG = " <<Incorrect value !>>";
    public static final String EMAIL_NOT_FOUND_MSG = "email missing";
    public static final String NOTHING_FOUND_MSG = "<Nothing found for your request> ";
    public static final String EMAIL_REGEX = "^[a-z0-9+_.-]+@(.+)$";
    public static final String NAME_COMPANY = "[A-Z][A-Za-z0-9\\-]+";
    public static final String FIRST_AND_LASTNAME_EMPLOYEE = "[A-Z][A-Za-z\\-]+";
    public static final String POSITION_EMPLOYEE = "[A-Za-z\s\\-]+";
    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public static final String INPUT_REQ_MSG = "Input is required ";
    public static final String WRONG_EMAIL_MSG = "Invalid email format. Email must be in lowercase.";
    public static final String WRONG_NAME_MSG = "Invalid name format. It must contain only letters, start with an uppercase letter followed by lowercase letters.";
    public static final String WRONG_ID_MSG = "Invalid company ID. It must be an integer.";
}



