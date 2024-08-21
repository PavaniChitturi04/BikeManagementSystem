package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bike {
    private int bikeId;
    private String make;
    private String model;
    private int year;
    private double rentalRatePerDay;
    private String availabilityStatus;

    // Constructors
    public Bike() {
    }

    public Bike(String make, String model, int year, double rentalRatePerDay, String availabilityStatus) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.availabilityStatus = availabilityStatus;
    }

    // Getters and Setters
    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public void setRentalRatePerDay(double rentalRatePerDay) {
        this.rentalRatePerDay = rentalRatePerDay;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    // Method to add a bike to the database
    public void addBike() throws ClassNotFoundException, SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Bike (make, model, year, rental_rate_per_day, availability_status) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, make);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, year);
            preparedStatement.setDouble(4, rentalRatePerDay);
            preparedStatement.setString(5, availabilityStatus);

            preparedStatement.executeUpdate();
        }
    }

    // Method to delete a bike from the database by ID
    public void deleteBike() throws ClassNotFoundException, SQLException {
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection
                     .prepareStatement("DELETE FROM Bike WHERE bike_id = ?")) {

            preparedStatement.setInt(1, bikeId);
            preparedStatement.executeUpdate();
        }
    }

    // Method to retrieve all bikes from the database
    public List<Bike> getAllBikes() throws ClassNotFoundException, SQLException {
        List<Bike> bikeList = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Bike");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Bike bike = new Bike();
                bike.setBikeId(resultSet.getInt("bike_id"));
                bike.setMake(resultSet.getString("make"));
                bike.setModel(resultSet.getString("model"));
                bike.setYear(resultSet.getInt("year"));
                bike.setRentalRatePerDay(resultSet.getDouble("rental_rate_per_day"));
                bike.setAvailabilityStatus(resultSet.getString("availability_status"));
                bikeList.add(bike);
            }
        }
        return bikeList;
    }
}
