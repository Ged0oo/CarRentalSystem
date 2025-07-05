package org.example;

import java.util.Date;

public class Rental {
    private Car car;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;
    private double totalCost;

    public Rental() {
        // Default constructor for Jackson
    }

    public Rental(Car car, Customer customer, Date rentalDate, Date returnDate, double totalCost) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    // Getters and setters
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Date getRentalDate() { return rentalDate; }
    public void setRentalDate(Date rentalDate) { this.rentalDate = rentalDate; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    @Override
    public String toString() {
        return "Rental{car=" + car + ", customer=" + customer +
               ", rentalDate=" + rentalDate + ", returnDate=" + returnDate +
               ", totalCost=" + totalCost + "}";
    }
}
