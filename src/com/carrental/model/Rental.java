
/*
 Represents an active rental transaction between a client and a vehicle.
 Manages the rental duration, calculates the final cost based on daily rates,
 and handles the vehicle return process.
 */

package com.carrental.model;
import com.carrental.model.vehicle.Vehicle;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Rental {
    private Client client;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalCost;

    public Rental(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
        // Sets the start time to the current moment
        this.startTime = LocalDateTime.now();
        // Rental is ongoing, so end time is initially null
        this.endTime = null;
        // Cost will be calculated upon return
        this.totalCost = 0.0;
    }

    public void finishRental() {
        this.endTime = LocalDateTime.now();

        // Calculates duration in full days (minimum 1 day)
        long days = ChronoUnit.DAYS.between(this.startTime, this.endTime);
        if (days < 1) {
            days = 1;
        }
        // Computes the total cost based on the vehicle's daily rate
        this.totalCost = vehicle.getDailyRate() * days;
        // Updates vehicle status
        vehicle.returnVehicle();
    }

    public Client getClient() {
        return client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Double getTotalCost() {
        return totalCost;
    }
}

