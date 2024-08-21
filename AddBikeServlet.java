package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddBikeServlet")
public class AddBikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String query = "INSERT INTO bike (make, model, year, rental_rate_per_day, availability_status) VALUES (?, ?, ?, ?, ?)";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String make = request.getParameter("make");
        String model = request.getParameter("model");
        int year = Integer.parseInt(request.getParameter("year"));
        double rentalRatePerDay = Double.parseDouble(request.getParameter("rental_rate_per_day"));
        String availabilityStatus = request.getParameter("availability_status");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bike";
        String username = "root"; // Replace with your database username
        String password = "Pavani@04"; // Replace with your database password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, make);
                preparedStatement.setString(2, model);
                preparedStatement.setInt(3, year);
                preparedStatement.setDouble(4, rentalRatePerDay);
                preparedStatement.setString(5, availabilityStatus);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Successful insertion
                    response.sendRedirect("addedSuccessfully.jsp"); // Redirect to a success page
                } else {
                    // Unsuccessful insertion
                    response.sendRedirect("unsuccessful.jsp"); // Redirect to an error page
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
