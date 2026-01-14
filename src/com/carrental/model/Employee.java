package com.carrental.model;

/*
 Represents a staff member working at the rental agency.
 Stores employment details such as position and unique ID,
 used for authorizing rentals and managing customer service.
 */

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String employeeId;

    public Employee(String firstName, String lastName, String position, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "First name: " + this.firstName +
                ", Last name: " + this.lastName +
                ", Position: " + this.position +
                ", Employee ID: " + this.employeeId;
    }
}
