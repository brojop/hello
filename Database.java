package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public final static String hostname = "cse-linux-01.unl.edu";
	public final static String username = "brojop"; // your database username
	public final static String password = "FWWbaQc0"; // your database password
	public final static String url = "jdbc:mysql://"+hostname+"/"+username;
	
	
	
	
	
	public static Connection SQLconnect() {
		Connection connection = null;
        try {
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            e.printStackTrace();
         
        }
        return connection;
    }


}