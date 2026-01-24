package com.carrental.util;

public enum VehicleStatus {
    AVAILABLE("Ready for rent"),
    RENTED("Currently rented"),
    UNAVAILABLE("Out of service / Repair");

    private final String description;

    VehicleStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name() + " (" + this.description + ")";
    }
}
