package com.carrental.model;

/**
 * Represents a client of the rental agency.
 * Holds personal data, contact information, and account status.
 */

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String driverLicenseNumber;
    private boolean isActive;

    public Client(String firstName, String lastName, String email, Address address, String driverLicenseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.driverLicenseNumber = driverLicenseNumber;
        this.isActive = true;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getFullname() {
        return this.firstName + " " + this.lastName;
    }

    // Updates the client's residence address.
    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }

    // Prevents the client from renting new vehicles without deleting data history.
    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }
}
