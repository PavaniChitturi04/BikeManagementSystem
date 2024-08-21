<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>View Bikes</title>
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
            text-align: center;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        a {
            display: block;
            text-align: center;
            text-decoration: none;
            color: white;
            font-weight: bold;
            padding: 5px 10px;
            border: 1px solid #836953;
            border-radius: 5px;
            transition: background-color 0.3s;
            margin: 20px auto;
            width: fit-content;
        }
        a:hover {
            background-color: #0056b3;
            color: #fff;
        }
        /* Additional style for CRUD buttons */
        nav {
            background-color: #836953;
            /* Vertically center items */
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center; /* Center align the list items */
        }
        nav ul li.crud {
            display: inline-block;
            margin: 0 10px;
        }
        nav h1 {
            list-style-type: none;
            color: white;
            margin: 0;
            padding: 0;
            text-align: center; /* Center align the list items */
        }
        body a[href="Main.jsp"] {
            color: black; /* Set color to black */
        }
    </style>
</head>
<body>
    <!-- Navigation bar -->
    <nav>
        <h1>Bike Management System</h1>
        <ul>
            <li class="crud"><a href="addBike.jsp">Add Bike</a></li>
            <li class="crud"><a href="viewBike.jsp">View Bike</a></li>
            <li class="crud"><a href="updateBike.jsp">Update Bike</a></li>
            <li class="crud"><a href="deleteBike.jsp">Delete Bike</a></li>
        </ul>
    </nav>

    <h2>View Bikes</h2>
    <form action="ViewBikeServlet" method="get">
        <input type="submit" value="View Bikes">
    </form>
    
    <a href="Main.jsp">Home</a>
</body>
</html>
