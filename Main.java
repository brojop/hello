package unl.soc;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			while(true) {

				Screens.mainWindow();
				System.out.println("Enter your username: ");
				
				//check for username and password here

				String username = s.next();
				
				System.out.println("Enter your password: ");
				String userPassword = s.next();
				
				//works with using JDBC method
			//	boolean authentication = authenticateUser(username, userPassword);
			//		if(authentication) {
			//			System.out.println("Successfully logged in!");
			//		} else {
			//			System.out.println("Username or password is incorrect, please try again: ");
			//			continue;
			//		}
				
				
				Screens.accountWindow();
				String userInput = s.next();
				
				
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
