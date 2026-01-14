package com.carrental.model.vehicle;

/*
 Represents a utility vehicle designed primarily for transporting cargo.
 Characterized by a large cargo space and load capacity.
 Typically requires the same license as a passenger car if under 3.5 tons.
 */

public class DeliveryVan extends Vehicle {
    private double cargoCapacity;
    private double cargoVolume;
    private double height;

    public DeliveryVan(String brand, String model, String licensePlate,
                       int productionYear, double mileage, double dailyRate, double fuelConsumption,
                       double cargoCapacity, double cargoVolume, double height) {
        super(brand, model, licensePlate, productionYear, mileage, dailyRate, fuelConsumption);
        this.cargoCapacity = cargoCapacity;
        this.cargoVolume = cargoVolume;
        this.height = height;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getFuelEfficiency() {
        return super.getFuelConsumption();
    }

    @Override
    public String getRequiredLicenseCategory() {
        return  "B";
    }

    @Override
    public int getServiceFrequency() {
        return 35000;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        " Cargo capacity: " + this.cargoCapacity +
                        " Cargo volume m3: " + this.cargoVolume +
                        " Height: " + this.height;
    }
}
