# Bike Management System

## Introduction
The **Bike Management System** is a Java-based application designed to manage a list of bikes using CRUD (Create, Read, Update, Delete) operations. It uses **JDBC** (Java Database Connectivity) for database interaction and **MySQL** as the database management system. Users can perform operations such as adding new bikes, viewing bike details, updating bike information, and deleting bikes from the database.

## Features
- **Create**: Add a new bike to the system.
- **Read**: View details of all bikes stored in the system.
- **Update**: Modify existing bike details.
- **Delete**: Remove a bike from the system.

## Technologies Used
- **Java**: Programming language for application development.
- **JDBC**: For database connectivity between the Java application and MySQL.
- **MySQL**: Relational database for storing bike records.
- **MySQL Workbench**: For managing and interacting with the database (optional).

## Prerequisites
To run this project, you will need the following:
1. **Java Development Kit (JDK)**: Ensure that JDK 8 or above is installed.
2. **MySQL**: Install MySQL server to create and manage the database.
3. **MySQL Connector for Java (JDBC Driver)**: Ensure the JDBC driver is added to your project's classpath.
4. **IDE**: Use an Integrated Development Environment like Eclipse, IntelliJ IDEA, or NetBeans (optional).
5. **MySQL Workbench**: (Optional) for managing the database graphically.

## Database Setup
1. **Create Database**: Create a database named `bike_management` in MySQL.
    ```sql
    CREATE DATABASE bike_management;
    ```
   
2. **Create Table**: Inside the `bike_management` database, create a table `bikes` to store bike information.
    ```sql
    CREATE TABLE bikes (
        id INT AUTO_INCREMENT PRIMARY KEY,
        bike_name VARCHAR(50),
        bike_model VARCHAR(50),
        price DECIMAL(10, 2)
    );
    ```

## Project Setup
1. **Clone or Download the Project**: Download or clone this repository to your local machine.
   
2. **Database Configuration**:
    - Open the project and navigate to the file where the JDBC connection is established (e.g., `DatabaseConnection.java`).
    - Modify the connection string with your MySQL database credentials:
      ```java
      String url = "jdbc:mysql://localhost:3306/bike_management";
      String username = "your_username";  // Replace with your MySQL username
      String password = "your_password";  // Replace with your MySQL password
      ```

3. **Add MySQL Connector (JAR)**: Download the MySQL Connector JAR file and add it to your project's classpath or dependencies.

## Running the Project
1. Compile the Java files in your IDE or through the terminal using `javac`.
2. Run the main class (`BikeManagementSystem.java`) from your IDE or via terminal:
    ```bash
    java BikeManagementSystem
    ```
3. Interact with the application by performing various CRUD operations through the command-line interface (CLI) or any UI (if implemented).

## CRUD Operation Examples

- **Add a New Bike**:
    The application will prompt you to enter the bike name, model, and price, which will be saved in the database.

- **View All Bikes**:
    The application will fetch and display all bike records stored in the `bikes` table.

- **Update Bike Information**:
    You can select a bike based on its ID and update its name, model, or price.

- **Delete a Bike**:
    You can delete a bike by specifying its ID.

## Code Overview

### 1. Database Connection (`DatabaseConnection.java`)
This class establishes a connection to the MySQL database using JDBC.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bike_management";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }
}
