package com.carrental.model;

/**
 * Represents a physical address of a client or an employee.
 */

public class Address {
    private String street;
    private String houseNumber;
    private String city;
    private String zipCode;
    private String country;
    private String state;


    public Address(String street, String houseNumber, String city, String zipCode, String country, String state) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullAddress() {
        return
        "Street: " + this.street + " House number: " + this.houseNumber + " City: " + this.city + " Zip code: " + this.zipCode +
                " State" + this.state + " Country:" + this.country;

    }
}
