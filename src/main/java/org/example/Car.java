package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;

public class Car {
	int id; 
	String model;
	String type;
	double dailyRate;
	String status;
	Date bookedFrom;
	Date bookedTo;

    public Car() {}

    public Car(int id, String model, String type, double dailyRate, String status, Date bookedFrom, Date bookedTo) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.dailyRate = dailyRate;
        this.status = status;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
    }

	public int getId() {return id;}
	public String getModel() {return model;}
	public String getType() {return type;}
	public double getDailyRate() {return dailyRate;}
	public String getStatus() {return status;}
	public Date getBookedFrom() {return bookedFrom;}
	public Date getBookedTo() {return bookedTo;}

	public void setId(int id) {this.id = id;}
	public void setModel(String model) {this.model = model;}
	public void setType(String type) {this.type = type;}
	public void setDailyRate(double dailyRate) {this.dailyRate = dailyRate;}
	public void setStatus(String status) {this.status = status;}
	public void setBookedFrom(Date bookedFrom) {this.bookedFrom = bookedFrom;}
	public void setBookedTo(Date bookedTo) {this.bookedTo = bookedTo;}

	@Override
	public String toString() {
		return "Car{" +
				"id=" + id +
				", model='" + model + '\'' +
				", type='" + type + '\'' +
				", dailyRate=" + dailyRate +
				", status='" + status + '\'' +
				", bookedFrom=" + bookedFrom +
				", bookedTo=" + bookedTo +
				'}';
	}

	public void storeCarsTXT() {
		File file = new File("cars_data.txt");
		String format = "%d,%s,%s,%.2f,%s,%s,%s";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String bookedFromStr = (bookedFrom != null) ? sdf.format(bookedFrom) : "null";
		String bookedToStr   = (bookedTo != null) ? sdf.format(bookedTo)   : "null";

		String currentCar = String.format(format, id, model, type, dailyRate, status, bookedFromStr, bookedToStr);

		boolean exists = false;
		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = reader.readLine()) != null) {
					if (line.trim().equals(currentCar)) {
						exists = true;
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage());
				return;
			}
		}

		if (!exists) {
			try (FileWriter writer = new FileWriter(file, true)) {
				writer.write(currentCar + "\n");
				System.out.println("Car appended to " + file.getAbsolutePath());
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		} else {
			System.out.println("Car already exists in the file.");
		}
	}

	public static List<Car> loadCarsTXT() {
		File file = new File("cars_data.txt");
		List<Car> cars = new ArrayList<>();

		if (!file.exists()) {
			System.out.println("No car data file found.");
			return cars;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 7) {
					try {
						int id = Integer.parseInt(parts[0].trim());
						String model = parts[1].trim();
						String type = parts[2].trim();
						double dailyRate = Double.parseDouble(parts[3].trim());
						String status = parts[4].trim();

						Date bookedFrom = parts[5].trim().equals("null") ? null : sdf.parse(parts[5].trim());
						Date bookedTo   = parts[6].trim().equals("null") ? null : sdf.parse(parts[6].trim());

						cars.add(new Car(id, model, type, dailyRate, status, bookedFrom, bookedTo));
					} catch (NumberFormatException | ParseException e) {
						System.out.println("Skipping invalid line: " + line);
					}
				}
			}
			System.out.println("Car data loaded from " + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("Error reading car data file: " + e.getMessage());
		}

		return cars;
	}


}
