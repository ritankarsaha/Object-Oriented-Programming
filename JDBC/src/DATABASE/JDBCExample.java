package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample {
    public static void main(String[] args) {
       
    	String url = "jdbc:mysql://localhost:3306/Employees?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "ritankar123@@";

        // Establish the database connection
        try {
            // Optionally load the MySQL JDBC driver (depends on your setup)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Get the connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Close the connection
            conn.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.out.println("Error establishing the connection!");
            e.printStackTrace();  // Prints the full stack trace of the SQLException
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
            e.printStackTrace();  // Prints the full stack trace if the driver class isn't found
        }
    }
}


