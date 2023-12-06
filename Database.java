package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	public final static String hostname = "cse-linux-01.unl.edu";
	public final static String username = "brojop2"; // your database username
	public final static String password = "YogaepaeS9oo"; // your database password
	public final static String url = "jdbc:mysql://" + hostname + "/" + username;

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
	String tableName = "Users";
	int numberofRows = getnumberOfRows(url, username, password, tableName);

	static int getnumberOfRows(String url, String username, String password, String tableName) {
		Connection connection = Database.SQLconnect();
		String rowStatement = "SELECT COUNT(*) FROM"+ tableName;
		try {
			PreparedStatement SQLcheck = connection.prepareStatement(rowStatement);
			ResultSet rowResult = SQLcheck.executeQuery();
			if (rowResult.next()) {
	            return rowResult.getInt(1);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}