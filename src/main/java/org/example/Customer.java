package org.example;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;

    public Customer() {
        // Default constructor required for Jackson
    }

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters (required for Jackson)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', email='" + email + "', phoneNumber='" + phoneNumber + "'}";
    }
}
