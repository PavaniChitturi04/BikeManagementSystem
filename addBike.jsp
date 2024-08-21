<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Bike</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        form {
            max-width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Add New Bike</h2>
    <form action="AddBikeServlet" method="post">
        <label for="make">Make:</label>
        <input type="text" id="make" name="make" required><br><br>
        
        <label for="model">Model:</label>
        <input type="text" id="model" name="model" required><br><br>
        
        <label for="year">Year:</label>
        <input type="number" id="year" name="year" required><br><br>
        
        <label for="rental_rate_per_day">Rental Rate Per Day:</label>
        <input type="number" id="rental_rate_per_day" name="rental_rate_per_day" step="0.01" required><br><br>
        
        <label for="availability_status">Availability Status:</label>
        <select id="availability_status" name="availability_status" required>
            <option value="Available">Available</option>
            <option value="Not Available">Not Available</option>
        </select><br><br>
        
        <input type="submit" value="Add Bike">
    </form>
    <a href="Main.jsp">Go to Home</a>
</body>
</html>
