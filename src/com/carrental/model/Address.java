package com.carrental.model;

/**
 * Represents a physical address of a client or an employee.
 */

public class Address {
    private String street;
    private String houseNumber;
    private String city;
    private String zipCode;

    public Address(String street, String houseNumber, String city, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return
        "Street: " + this.street + " House number: " + this.houseNumber + " City: " + this.city + " Zip code: " + this.zipCode;
    }
}
