package test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/ViewBikeServlet")
public class ViewBikeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bike", "root", "Pavani@04");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM bike");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bike List</title>");
            out.println("<style>");
            out.println("table {");
            out.println("    border-collapse: collapse;");
            out.println("    width: 100%;");
            out.println("}");
            out.println("th, td {");
            out.println("    border: 1px solid #dddddd;");
            out.println("    text-align: left;");
            out.println("    padding: 8px;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #f2f2f2;");
            out.println("}");
            out.println("nav {");
            out.println("    background-color: #836953;");
            out.println("    padding: 10px 20px; /* Add padding to separate login details */");
            out.println("    display: flex;");
            out.println("    justify-content: space-between; /* Align items with space between */");
            out.println("    align-items: center; /* Vertically center items */");
            out.println("}");
            out.println("nav h1 {");
            out.println("    color: #fff;");
            out.println("    margin: 0;");
            out.println("}");
            out.println("nav .login-details {");
            out.println("    color: #fff;");
            out.println("    text-align: right;");
            out.println("}");
            out.println("nav ul {");
            out.println("    list-style-type: none;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("nav ul li {");
            out.println("    display: inline;");
            out.println("    margin: 0 10px;");
            out.println("}");
            out.println("nav ul li a {");
            out.println("    color: #fff;");
            out.println("    text-decoration: none;");
            out.println("}");
            out.println(".red-text {");
            out.println("    color: #836953; /* Sets text color to red */");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav>");
            out.println("<p style=\"text-align: right;\">");
            out.println("<h1><a href=\"\" class=\"red-text\">kjdkschbhcgvbxhcvbxvnbnxcbsdcx</a>Bike Management System</h1>");
            out.println("</p>");
            out.println("<div class=\"login-details\">");
            out.println("Hello, " + request.getSession().getAttribute("username") + "!");
            out.println("</div>");
            out.println("</nav>");

            // Output the second navigation links
            out.println("<nav>");
            out.println("<p style=\"text-align: center;\">");
            out.println("<ul>");
            out.println("<li><a href=\"addBike.jsp\">Add Bike</a></li>");
            out.println("<li><a href=\"viewBike.jsp\">View Bike</a></li>");
            out.println("<li><a href=\"updateBike.jsp\">Update Bike</a></li>");
            out.println("<li><a href=\"deleteBike.jsp\">Delete Bike</a></li>");
            out.println("</ul>");
            out.println("</p>");
            out.println("</nav>");

            out.println("<h2>Bike List</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Make</th>");
            out.println("<th>Model</th>");
            out.println("<th>Year</th>");
            out.println("<th>Rental Rate Per Day</th>");
            out.println("<th>Availability Status</th>");
            out.println("</tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("bike_id") + "</td>");
                out.println("<td>" + resultSet.getString("make") + "</td>");
                out.println("<td>" + resultSet.getString("model") + "</td>");
                out.println("<td>" + resultSet.getInt("year") + "</td>");
                out.println("<td>" + resultSet.getDouble("rental_rate_per_day") + "</td>");
                out.println("<td>" + resultSet.getString("availability_status") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<a href='Main.jsp'>Go to home</a>");
            out.println("</body>");
            out.println("</html>");

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }
}
