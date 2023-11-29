package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");

            while (resultSet.next()) {
                // Process each row
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    

		
		try (Scanner s = new Scanner(System.in)) {
			while(true) {
				//insert first window

				Screens.mainWindow();
				System.out.println("Enter your username: ");
				
				//check for username and password here

				String userInput = s.next();
				
				System.out.println("Enter your password: ");
				userInput = s.next();
				
				//if statement to check if username and password match an existing account
				
				Screens.accountWindow();
				
				
				switch (userInput) {
				
				case "P":
					Screens.postWindow();
					
					userInput = s.next();
					while(true) {
						switch(userInput) {
						case "+":
							System.out.println("Please write your post: ");
							userInput = s.next();
							//add userInput to the post list
							//change back to post window
							userInput = s.next();
							
							continue;
						}
						
					}
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
							
							continue;
						}
					}
					
				/**
				 * Admin window
				 * 
				 * case "M": 
				*/	
				case "Q":
					break;
				
				
				}
			}
		}
	}

}