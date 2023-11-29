package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public final static String hostname = "cse-linux-01.unl.edu";
	public final static String username = "brojop"; // your database username
	public final static String password = "FWWbaQc0"; // your database password
	public final static String url = "jdbc:mysql:cse/brojop";
	private Connection connection;
	
	
	public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}