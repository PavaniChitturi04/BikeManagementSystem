<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        nav {
            background-color: #836953;
            padding: 10px 0;
            text-align: center;
        }
        nav h1 {
            color: #fff;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        nav ul li {
            display: inline;
            margin: 0 10px;
        }
        nav ul li a {
            color: #fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <!-- Navigation bar -->
    <nav>
        <h1>Bike Management System</h1>
        <ul>
            <li><a href="addBike.jsp">Add Bike</a></li>
            <li><a href="viewBike.jsp">View Bikes</a></li>
            <li><a href="updateBike.jsp">Update Bike</a></li>
            <li><a href="deleteBike.jsp">Delete Bike</a></li>
        </ul>
    </nav>
</body>
</html>