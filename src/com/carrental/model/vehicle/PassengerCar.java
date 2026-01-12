package com.carrental.model.vehicle;

public class PassengerCar extends Vehicle {
    private String fuelType;
    private String transmission;
    private int numberOfDoors;
    private int numberOfSeats;
    private double fuelConsumption;

    public PassengerCar(String brand, String model, String licensePlate,
                        int productionYear, double mileage, double dailyRate,
                        String fuelType, String transmission, int numberOfDors,
                        int numberOfSeats, double fuelConsumption) {
        super(brand, model, licensePlate, productionYear, mileage, dailyRate);
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.numberOfDoors = numberOfDors;
        this.numberOfSeats = numberOfSeats;
        this.fuelConsumption = fuelConsumption;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getFuelEfficiency() {
        return  this.fuelConsumption;
    }

    @Override
    public String getRequiredLicenseCategory() {
        return "B";
    }

    @Override
    public int getServiceFrequency() {
        return 15000;
    }
    @Override
    public String toString() {
        return
                super.toString()
                + " " + this.fuelType + " " + this.transmission + " " + this.numberOfDoors + " " + this.numberOfSeats;
    }
}
