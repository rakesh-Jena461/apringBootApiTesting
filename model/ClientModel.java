package com.myproject.my_Domy_project.model;




public class ClientModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matcherPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatcherPassword() {
        return matcherPassword;
    }

    public void setMatcherPassword(String matcherPassword) {
        this.matcherPassword = matcherPassword;
    }


    public ClientModel(String firstName, String lastName, String email, String password, String matcherPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.matcherPassword = matcherPassword;
    }

    public ClientModel() {
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", matcherPassword='" + matcherPassword + '\'' +
                '}';
    }
}
