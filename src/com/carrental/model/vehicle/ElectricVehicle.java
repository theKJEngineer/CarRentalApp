package com.carrental.model.vehicle;

/*
 Represents an eco-friendly vehicle powered exclusively by an electric motor.
 Extends the base Vehicle abstraction by replacing fuel metrics with
 battery capacity, charging range, and energy consumption data.
 Ideal for city driving with zero emissions.
 */

public class ElectricVehicle extends Vehicle {
    private double batteryCapacity;
    private double range;
    private double energyConsumption;

    public ElectricVehicle(String brand, String model, String licensePlate,
                           int productionYear, double mileage, double dailyRate, double fuelConsumption,
                           double batteryCapacity, double range) {
        super(brand, model, licensePlate, productionYear, mileage, dailyRate,fuelConsumption);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        this.energyConsumption = fuelConsumption;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getRange() {
        return range;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    @Override
    public String toString() {
        return
        super.toString() +
                " Battery Capacity:  " + this.batteryCapacity +
                " Range: " + this.range +
                " Energy Consumption:  " + this.energyConsumption;
    }

    @Override
    public double getFuelEfficiency() {
        return this.energyConsumption;
    }

    @Override
    public String getRequiredLicenseCategory() {
        return "B";
    }

    @Override
    public int getServiceFrequency() {
        return 30000;
    }

}
