package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args, Connection connection) {
		try (Scanner s = new Scanner(System.in)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection sqlConnection = DriverManager.getConnection(Database.url, Database.username, Database.password);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			while(true) {

				Screens.mainWindow();
				String userInput;
				System.out.println("Enter your username: ");
				String Username = s.next();
				//check for username and password here
				String statement1 ="SELECT * FROM User WHERE username = ?";
				try (PreparedStatement SQLcheck = connection.prepareStatement(statement1)) {
	                // Set the parameter value
					SQLcheck.setString(1, Username);

	                // Execute the query
	                ResultSet usernameResult = SQLcheck.executeQuery();

	                // Check if any rows are returned
	                if (usernameResult.next()) {
	                    System.out.println("Your username is in the Database");
	                } else {
	                    System.out.println("Your username isn't in the Database");
	                }
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				
				
				System.out.println("Enter your password: ");
				String Password = s.next();
				String statement2 ="SELECT * FROM User WHERE password = ?";
				try (PreparedStatement SQLcheck = connection.prepareStatement(statement2)) {
	                // Set the parameter value
					SQLcheck.setString(1, Password);

	                // Execute the query
	                ResultSet passwordResult = SQLcheck.executeQuery();

	                // Check if any rows are returned
	                if (passwordResult.next()) {
	                    System.out.println("Your username is in the Database");
	                } else {
	                    System.out.println("Your username isn't in the Database");
	                }
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//if statement to check if username and password match an existing account
				
				Screens.accountWindow();
				userInput = s.next();
				
				
				switch (userInput) {
				
				case "P":
					Screens.postWindow();
					
					userInput = s.next();
					while(true) {
						switch(userInput) {
						case "+":
							System.out.println("Please write your post: ");
							String firstWord=s.next();
					    	String words = s.nextLine();
					    	String fullSentence = firstWord+words;
					    	//add fullSentence into Post table(sql)
							userInput = s.next();
							Screens.postWindow();							
							continue;
							
						case "B":
							break;
							
						default:
							System.out.println("Please enter a valid character: ");
							userInput = s.next();
							continue;
						}
						break;
					}
					continue;
				
				case "V": 
					Screens.visibilityWindow();
					userInput = s.next();
					while(true) {
						switch(userInput) {
						case "+":
							
							
							continue;
							
						case "-":
							
							continue;
							
						case "B":
							break;
							
						default:
							System.out.println("Please enter a valid character");
							userInput = s.next();
							continue;
						}
						break;
					}
					continue;
				/**
				 * Admin window
				 * 
				 * case "M": 
				*/	
				case "Q":
					break;
					
				default:
					System.out.println("Please enter a valid character.");
					userInput = s.next();
					continue;
				
				
				}
				close();
			}
			
		}
	}
	private static void close() {
		return;		
	}
}