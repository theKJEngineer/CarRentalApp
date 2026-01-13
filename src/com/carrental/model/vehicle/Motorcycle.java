package com.carrental.model.vehicle;

/*
 Represents a two-wheeled motor vehicle in the rental fleet.
 Extends the base Vehicle abstraction with motorcycle-specific properties
 such as engine displacement and accessory details (e.g., luggage box).
 Requires a specific license category usually distinct from standard cars.
 */

public class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private String type;
    private boolean hasTopCase;
    private double fuelConsumption;

    public Motorcycle(String brand, String model, String licensePlate,
                      int productionYear, double mileage, double dailyRate,
                      int engineDisplacement, String type, boolean hasTopCase, double fuelConsumption) {
        super(brand, model, licensePlate, productionYear, mileage, dailyRate);
        this.engineDisplacement = engineDisplacement;
        this.type = type;
        this.hasTopCase = hasTopCase;
        this.fuelConsumption = fuelConsumption;
    }

    public void setHasTopCase(boolean hasTopCase) {
        this.hasTopCase = hasTopCase;
    }

    public int getEngineDisplacment() {
        return engineDisplacement;
    }

    public String getType() {
        return type;
    }

    public boolean hasTopCase() {
        return hasTopCase;
    }

    @Override
    public double getFuelEfficiency() {
        return this.fuelConsumption;
    }

    @Override
    public String getRequiredLicenseCategory() {
        return  "A";
    }

    @Override
    public int getServiceFrequency() {
        return 6000;
    }

    @Override
    public String toString() {
        return
        super.toString()
                + "Engine displacement: " + this.engineDisplacement + "Type " + this.type + "Has top case: " + this.hasTopCase;

    }
}
