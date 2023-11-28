package unl.soc;

import java.util.*;

public class Main {

	public static void main(String[] args) {
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
