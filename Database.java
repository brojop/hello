package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public final static String hostname = "cse-linux-01.unl.edu";
	public final static String username = "brojop"; // your database username
	public final static String password = "FWWbaQc0"; // your database password
	public final static String url = "jdbc:mysql:cse/brojop";
	
	
	
	
	private static Connection connection;
	public static void SQLconnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}