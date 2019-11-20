package com.studentapp.restassured.project.model;

import java.util.List;

public class StudentPojo {

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> cources;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public List<String> getCources() {
        return cources;
    }

    public void setCources(List<String> cources) {
        this.cources = cources;
    }
}
