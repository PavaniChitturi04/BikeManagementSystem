<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Bike Management System</title>
    <style>
        
        body {
        font-family: Arial, sans-serif;
    background-image: url("C:\Users\Srinivasa Rao\Downloads\wp6477360-4k-bike-wallpapers.jpg"); /* Path to your background image */
    background-size: cover;     /* Cover the entire background */
    background-position: center; /* Center the background image */
    background-repeat: no-repeat; /* Do not repeat the background image */
    /* Optionally, you can set background color as fallback */
    background-color: #f8f9fa; /* Fallback color */
    margin: 0;
            padding: 0;
  }
        h2 {
            text-align: center;
            color: #333;
            font-size: 40px;
        }
        table {
            margin: 50px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 50px;
            border: 15px solid #ADD8E6;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }
        a:hover {
            color: #0056b3;
        }
        h3 {
            text-align: center;
            color: #333;
            font-size: 30px;
        }
    </style>
</head>
<body >
    <h3>Hello, <%= session.getAttribute("username") %>!</h3>
    <h2>Welcome to Bike Rental Management System!</h2>
    
    <table>
        <tr>
            <th><a href="addBike.jsp">Add Bikes</a></th>
            <th><a href="viewBike.jsp">View Bikes</a></th>
            <th><a href="updateBike.jsp">Update Bikes</a></th>
            <th><a href="deleteBike.jsp">Delete Bikes</a></th>
        </tr>
        
    </table>
</body>
</html>
