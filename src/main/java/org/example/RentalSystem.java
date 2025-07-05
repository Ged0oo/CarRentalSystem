package org.example;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class RentalSystem {

    List<Car> cars;
    List<Customer> customers;
    List<Rental> rentals;

    public RentalSystem(List<Car> cars, List<Customer> customers, List<Rental> rentals) {
        this.cars = cars;
        this.customers = customers;
        this.rentals = rentals;
    }

    public List<Car> getCars() { return cars; }
    public List<Customer> getCustomers() { return customers; }
    public List<Rental> getRentals() { return rentals; }

    public void setCars(List<Car> cars) { this.cars = cars; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
    public void setRentals(List<Rental> rentals) { this.rentals = rentals; }

	public void addCar(Car car) {
		if (car != null && cars.stream().noneMatch(c -> c.getId() == car.getId())) {
			cars.add(car);
			System.out.println("Car added successfully.");
		} else {
			System.out.println("Car already exists or is invalid.");
		}
	}

	public void addCustomer(Customer customer) {
		if (customer != null && customers.stream().noneMatch(c ->
				c.getEmail().equalsIgnoreCase(customer.getEmail())
				&& c.getPhoneNumber().equals(customer.getPhoneNumber()))) {
			customers.add(customer);
			System.out.println("Customer added successfully.");
		} else {
			System.out.println("Customer already exists or is invalid.");
		}
	}

	public void addRental(Rental rental) {
		if (rental != null && rentals.stream().noneMatch(r ->
				r.getCar().getId() == rental.getCar().getId() &&
				r.getCustomer().getEmail().equalsIgnoreCase(rental.getCustomer().getEmail()) &&
				r.getRentalDate().equals(rental.getRentalDate()))) {
			rentals.add(rental);
			System.out.println("Rental added successfully.");
		} else {
			System.out.println("Rental already exists or is invalid.");
		}
	}


    public void processRental(Rental rental) {
        if (rental != null && cars.contains(rental.getCar()) && customers.contains(rental.getCustomer())) {
            rentals.add(rental);
            Car rentedCar = rental.getCar();
            rentedCar.setStatus("Rented");
            System.out.println("Rental processed successfully.");
            saveRentalsToJSON("rentals.json");
        } else {
            System.out.println("Invalid rental details.");
        }
    }

    public void viewAvailableCars() {
        for (Car car : cars) {
            if ("Available".equals(car.getStatus())) {
                System.out.println(car);
            }
        }
    }

    public void viewRentalHistory() {
        if (rentals.isEmpty()) {
            System.out.println("No rental history available.");
        } else {
            for (Rental rental : rentals) {
                System.out.println(rental);
            }
        }
    }

    public void saveCarsToJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), cars);
            System.out.println("Cars saved to JSON.");
        } catch (IOException e) {
            System.out.println("Error saving cars: " + e.getMessage());
        }
    }

    public void loadCarsFromJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

        try {
            cars.clear();
            cars = mapper.readValue(new File(filename), new TypeReference<List<Car>>() {});
            System.out.println("Cars loaded from JSON.");
        } catch (IOException e) {
            System.out.println("Error loading cars: " + e.getMessage());
        }
    }

    public void saveCustomersToJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), customers);
            System.out.println("Customers saved to JSON.");
        } catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    public void loadCustomersFromJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            customers.clear();
            customers = mapper.readValue(new File(filename), new TypeReference<List<Customer>>() {});
            System.out.println("Customers loaded from JSON.");
        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    public void saveRentalsToJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), rentals);
            System.out.println("Rentals saved to JSON.");
        } catch (IOException e) {
            System.out.println("Error saving rentals: " + e.getMessage());
        }
    }

    public void loadRentalsFromJSON(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        try {
            rentals.clear();
            rentals = mapper.readValue(new File(filename), new TypeReference<List<Rental>>() {});
            System.out.println("Rentals loaded from JSON.");
        } catch (IOException e) {
            System.out.println("Error loading rentals: " + e.getMessage());
        }
    }
}
