package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Rental> rentals = new ArrayList<>();

        RentalSystem rentalSystem = new RentalSystem(cars, customers, rentals);

        // Load existing data
        rentalSystem.loadCarsFromJSON("cars.json");
        rentalSystem.loadCustomersFromJSON("customers.json");
        rentalSystem.loadRentalsFromJSON("rentals.json");

        System.out.println("\n--- Loaded Available Cars ---");
        rentalSystem.viewAvailableCars();

        // Add a new car
        Car newCar = new Car(5, "Hyundai Elantra", "Sedan", 45.0, "Available", null, null);
        rentalSystem.addCar(newCar);

        // Add a new customer
        Customer newCustomer = new Customer("Charlie Black", "charlie@domain.com", "999-888-7777");
        rentalSystem.addCustomer(newCustomer);

        // Add a new rental
        Rental newRental = new Rental(newCar, newCustomer, new Date(), new Date(System.currentTimeMillis() + 86400000), 45.0);
        rentalSystem.addRental(newRental);

        System.out.println("\n--- Updated Available Cars ---");
        rentalSystem.viewAvailableCars();

        System.out.println("\n--- All Rentals ---");
        rentalSystem.viewRentalHistory();

        rentalSystem.saveCarsToJSON("cars.json");
        rentalSystem.saveCustomersToJSON("customers.json");
        rentalSystem.saveRentalsToJSON("rentals.json");

        System.out.println("\nAll data has been updated and saved to JSON.");
    }
}
