package com.mycompany.liabrary;

public class Employee extends Stakeholder {
    private String username;
    private String password;

    public Employee(String username, String password, String firstName,String lastName, char gender, String phone) {
        super(firstName, lastName, gender, phone);
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
    
}
