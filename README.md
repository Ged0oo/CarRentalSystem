# Car Rental System

A simple object-oriented Java application for managing a car rental service. This project stores all data using JSON files and provides basic CRUD operations on cars, customers, and rentals.

## Overview

This system models the core components of a car rental service, including cars, customers, and their rental history. It uses **Java OOP principles**, **Jackson for JSON serialization**, and **Maven** for building and dependency management.

---

## Project Structure

### `Main.java`
- **Purpose:** The entry point of the application.
- **Responsibilities:**
  - Loads data from JSON files.
  - Demonstrates adding and viewing operations.
  - Saves updated data back to JSON files.

### `Car.java`
- **Purpose:** Represents a car in the system.
- **Fields:**
  - `id` (int)
  - `model` (String)
  - `type` (String)
  - `dailyRate` (double)
  - `status` (String) — e.g., `"Available"`, `"Rented"`
  - `bookedFrom` (Date)
  - `bookedTo` (Date)
- **Methods:** Getters, setters, `toString()`, constructors

### `Customer.java`
- **Purpose:** Represents a customer who rents cars.
- **Fields:**
  - `name` (String)
  - `email` (String)
  - `phoneNumber` (String)
- **Methods:** Getters, setters, `toString()`, constructors

### `Rental.java`
- **Purpose:** Represents a rental transaction between a customer and a car.
- **Fields:**
  - `car` (Car)
  - `customer` (Customer)
  - `rentalDate` (Date)
  - `returnDate` (Date)
  - `totalCost` (double)
- **Methods:** Getters, setters, `toString()`, constructors

### `RentalSystem.java`
- **Purpose:** Core controller class that manages business logic.
- **Responsibilities:**
  - Load and save cars, customers, and rentals from JSON
  - Add new cars, customers, and rentals
  - Process a rental (update status, store details)
  - View available cars
- **Dependencies:** Jackson (for JSON), Java IO/Date

---

## Features

- View available cars  
- Add new cars, customers, rentals  
- Save/load all data using JSON files  
- Prevent duplicate entries when adding  
- Calculate total rental cost  
- Print rental records

---

## Technologies Used

- Java 19
- Maven
- Jackson (for JSON I/O)
- SimpleDateFormat

---

## How to Run

### 1. Clone the repo

```bash
git clone https://github.com/Ged0oo/CarRentalSystem.git
cd CarRentalSystem
```

### 2. Compile & Run

```bash
mvn clean compile exec:java
```


## Sample JSON File Format

### cars.json

```json
[
  {
    "id": 1,
    "model": "Toyota Camry",
    "type": "Sedan",
    "dailyRate": 50.0,
    "status": "Available",
    "bookedFrom": null,
    "bookedTo": null
  }
]
```


### customers.json

```json
[
  {
    "name": "John Doe",
    "email": "Johndoe@google.com",
    "phoneNumber": "123-456-7890"
  }
]
```

### rentals.json

```json
[
  {
    "car": {
      "id": 1,
      "model": "Toyota Camry",
      "type": "Sedan",
      "dailyRate": 50.0,
      "status": "Rented",
      "bookedFrom": null,
      "bookedTo": null
    },
    "customer": {
      "name": "John Doe",
      "email": "Johndoe@google.com",
      "phoneNumber": "123-456-7890"
    },
    "rentalDate": "2025-07-05",
    "returnDate": "2025-07-06",
    "totalCost": 50.0
  }
]
```


## Future Improvements
- Add GUI (JavaFX/Swing)
- Add CLI menu-based interface
- Add validation and conflict checks on booking dates
- Store data in database instead of JSON
- Add login & role-based user access