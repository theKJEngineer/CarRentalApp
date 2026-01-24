package com.carrental.manager;
import com.carrental.model.Client;
import com.carrental.model.Employee;
import com.carrental.model.Rental;
import com.carrental.model.vehicle.Vehicle;
import com.carrental.util.VehicleStatus;

import java.util.ArrayList;
import java.util.List;


/*
 * Manages the rental business logic.
 * Stores the fleet of vehicles and the history of rental transactions.
 * Handles the process of renting and returning vehicles.
 */

public class RentalAgency {
    private List<Vehicle> fleet;
    private List<Rental> rentals;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    // Adds a new vehicle to the agency's fleet
    public void addVehicle(Vehicle vehicle) {
        this.fleet.add(vehicle);
    }

    public Rental rentVehicle(Client client, Vehicle vehicle, Employee employee) {
        if (vehicle.getStatus() == VehicleStatus.AVAILABLE) {
            Rental rental = new Rental(client, vehicle);
            this.rentals.add(rental);
            vehicle.rent();
            System.out.println("SUCCESS: Vehicle " + vehicle.getBrand() + " rented to " + client.getFirstName());
            return rental;
        } else {
            System.out.println("FAILURE: Vehicle is not available. Current status: " + vehicle.getStatus());
            return null;
        }
    }

    /*
     * Handles the return of a vehicle.
     * Finds the active rental transaction and closes it.
     */

    public void returnVehicle(Vehicle vehicle) {
        Rental activeRental = null;

        for(Rental rental : rentals) {
            if (rental.getVehicle().equals(vehicle) && vehicle.getStatus() == VehicleStatus.RENTED) {
                activeRental = rental;
                break;
            }
        }

        if (activeRental != null) {
            activeRental.finishRental();

            System.out.println("RETURNED: " + vehicle.getBrand() + " " + vehicle.getModel());
            System.out.println("Total Cost: " + activeRental.getTotalCost());
        } else {
            System.out.println("ERROR: No active rental found for this vehicle.");
        }
    }

    public void printFleet() {
        System.out.println("\n--- FLEET STATUS ---");
        for (Vehicle v : fleet) {
            System.out.println(v); // Wykorzystuje metodę toString() z każdego pojazdu
        }
        System.out.println("--------------------\n");
    }
}
