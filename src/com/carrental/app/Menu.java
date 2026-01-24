package com.carrental.app;

import com.carrental.manager.RentalAgency;
import com.carrental.model.Address;
import com.carrental.model.Client;
import com.carrental.model.Employee;
import com.carrental.model.vehicle.DeliveryVan;
import com.carrental.model.vehicle.ElectricVehicle;
import com.carrental.model.vehicle.Motorcycle;
import com.carrental.model.vehicle.PassengerCar;
import com.carrental.model.vehicle.Vehicle;
import java.util.Scanner;

/*
 * Handles the textual user interface (CLI) for the application.
 * Orchestrates interactions between the user (input) and the RentalAgency logic (backend).
 */

public class Menu {
    private RentalAgency agency;
    private Scanner scanner;
    private Employee loggedEmployee;

    public Menu() {
        this.agency = new RentalAgency();
        this.scanner = new Scanner(System.in);
        this.loggedEmployee = new Employee("John", "Smith", "Manager", "EAM342");

        initializeData();
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== CAR RENTAL SYSTEM ===");
            System.out.println("Logged as: " + loggedEmployee.toString());
            System.out.println("1. Show Fleet (Available & Rented)");
            System.out.println("2. Rent a Vehicle");
            System.out.println("3. Return a Vehicle");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //

            switch (choice) {
                case 1:
                    agency.printFleet();
                    break;
                case 2:
                    handleRent();
                    break;
                case 3:
                    handleReturn();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /*
     * Walks the user through the vehicle rental process.
     * Collects Client and Address data, selects a vehicle, and attempts the transaction.
     */
    private void handleRent() {
        System.out.println("\n--- RENT A VEHICLE ---");

        System.out.print("Client First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Client Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Client Email: ");
        String email = scanner.nextLine();

        System.out.print("Client Driver License / ID: ");
        String idNumber = scanner.nextLine();

        // 2. ADRES (Wymagane przez klasę Address - aż 6 pól)
        System.out.println("-- Client Address --");
        System.out.print("Street: ");
        String street = scanner.nextLine();

        System.out.print("House Number: ");
        String houseNumber = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("Zip Code: ");
        String zipCode = scanner.nextLine();


        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("State (e.g. Mazowieckie): ");
        String state = scanner.nextLine();

        Address address = new Address(street, houseNumber, city, zipCode, country, state);

        Client client = new Client(firstName, lastName, email, address, idNumber);


        System.out.print("Enter License Plate of vehicle to rent: ");
        String plate = scanner.nextLine();

        Vehicle selectedVehicle = findVehicleByPlate(plate);

        if (selectedVehicle != null) {
            agency.rentVehicle(client, selectedVehicle, loggedEmployee);
        } else {
            System.out.println("Vehicle with plate " + plate + " not found.");
        }
    }

    private Vehicle findVehicleByPlate(String plate) {
        for (Vehicle v : agency.getFleet()) {
            if (v.getLicensePlate().equalsIgnoreCase(plate)) {
                return v;
            }
        }
        return null;
    }

    private void handleReturn() {
        System.out.println("\n--- RETURN A VEHICLE ---");
        System.out.print("Enter License Plate to return: ");
        String plate = scanner.nextLine();

        Vehicle vehicle = findVehicleByPlate(plate);
        if (vehicle != null) {
            agency.returnVehicle(vehicle);
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    /*
     * Pre-populates the system with a diverse set of vehicles.
     * Useful for testing without entering data manually every time.
     */
    private void initializeData() {
        agency.addVehicle(new PassengerCar("Toyota", "Corolla", "WA12345", 2022, 50000, 150.0, 6.5, "Petrol", "Manual", 5, 5));
        agency.addVehicle(new Motorcycle("Yamaha", "MT-07", "WB9999", 2023, 5000, 100.0, 4.5, 689, "Naked", false));
        agency.addVehicle(new DeliveryVan("Ford", "Transit", "KR55555", 2020, 120000, 250.0, 9.0, 1200, 10.5, 2.4));
        agency.addVehicle(new ElectricVehicle("Tesla", "Model 3", "EL001", 2024, 1000, 400.0, 16.0, 75.0, 500.0));
    }
}
