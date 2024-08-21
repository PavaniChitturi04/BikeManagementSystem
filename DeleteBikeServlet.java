package test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/DeleteBikeServlet")
public class DeleteBikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String query = "DELETE FROM bike WHERE bike_id = ?";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bikeIdStr = request.getParameter("bike_id");

        if (bikeIdStr == null || bikeIdStr.isEmpty()) {
            // Bike ID is required, handle the error accordingly
            response.sendRedirect("deleteBikeError.jsp");
            return;
        }

        int bikeId = Integer.parseInt(bikeIdStr);

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bike";
        String username = "root"; // Replace with your database username
        String password = "Pavani@04"; // Replace with your database password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, bikeId);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Successful deletion
                    response.sendRedirect("deletedSuccessfully.jsp"); // Redirect to a success page
                } else {
                    // Bike ID not found or deletion unsuccessful
                    response.sendRedirect("deleteError.jsp"); // Redirect to an error page
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exceptions
            response.sendRedirect("deleteError.jsp"); // Redirect to an error page
        }
    }
}
