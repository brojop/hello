package unl.soc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();
        //fix accounts
        Account currentAccount = null;
        //current account shouldn't be null
        List<Post> postList = new ArrayList<>();
        
        

        //make sure they don't all print at once when running
       // mainWindow
        
        
        Scanner s = new Scanner(System.in);
        while(true) {
        	Views.mainWindow();
        
        String userInput = s.next();

 
     
        switch(userInput) {
  
        
        case "R":
        	Views.accountRegistrationWindow();
        	System.out.println("Create new User Name: ");
        	userInput = s.next();
        	//accounts.put(userInput, currentAccount)
        	System.out.println("Create Password: ");
        	userInput = s.next();
        	System.out.println("Enter Phone Number: ");
        	userInput = s.next();
        //	Views.mainWindow();
        //	userInput = s.next();
        
        	break;
      
       
        case "L":
        	Views.accountLoginWindow();
        	System.out.println("Enter Username: ");
        	userInput = s.next();
        	System.out.println("Enter Password: ");
        	userInput = s.next();
        	switch(userInput) {
        	
        	case "+":
               	Views.newPostWindow();
               	break;
        
            case "A":
           	Views.displayTextArtOptions();
           	//break;
           	
            case "Q":
            	System.out.println("Application closed.");
            	break;
           	
           	default:
           		System.out.println("Incorrect Input, please select another choice");
           		userInput = s.next();
           		break;
        	}
        	break;
        	
     
      //  case "+":
        //   	Views.newPostWindow();
     //      	break;
    
        //case "A":
       	//Views.displayTextArtOptions();
       	//break;
       	
        case "Q":
        	System.out.println("Application closed.");
        	break;
       	
       	default:
       		System.out.println("Incorrect Input, please select another choice");
       		userInput = s.next();
       	//}
       	//read in no of art chosen by user and add to postList
        }
    
        
        close(s);
    }
    }
    
	private static void close(Scanner s) {
		return;		
	}
	
}