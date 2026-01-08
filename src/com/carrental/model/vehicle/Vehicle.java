package com.carrental.model.vehicle;

/**
 * Represents a base abstraction for all vehicles in the rental fleet.
 * Contains common properties shared by cars, motorcycles, and vans.
 */

public abstract class Vehicle {
    private String brand;
    private String model;
    private String licensePlate;
    private int productionYear;
    private double mileage;
    // price per day
    private double dailyRate;
    private boolean isAvailable;


    public Vehicle(String brand, String model, String licensePlate,
                   int productionYear, double mileage, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public double getMileage() {
        return mileage;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // instead of set method setting the daily rate
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    /**
     * Marks the vehicle as rented (unavailable).
     * If the vehicle is already rented, it prints a warning.
     */
    public void rent() {
        if (this.isAvailable) {
            this.isAvailable = false;
        } else {
            System.out.println("The car is rented and unavailable.");
        }
    }

    public void returnVehicle() {
        this.isAvailable = true;
    }

    public void updateMileage(double distanceDriven) {
        if (distanceDriven > 0) {
            this.mileage += distanceDriven;
        }
    }

    public String getDescription() {
        return this.brand + " " + this.model + " " + this.productionYear;
    }

    // Abstract methods - subclasses MUST implement these

    // liters per 100km or kWh per 100km
    public abstract double getFuelEfficiency();

    // The driving license category required to drive this vehicle
    public abstract String getRequiredLicenseCategory();

    // The distance in kilometers between required maintenance services.
    public abstract int getServiceFrequency();




}
