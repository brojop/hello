package unl.soc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Account> accountMap = new HashMap<>();
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
        	String userName = s.next();
        	System.out.println("Create Password: ");
        	String password = s.next();
        	System.out.println("Enter Phone Number: ");
        	String pNumber = s.next();
        	Account account = new Account(userName, password, pNumber);
        	accountMap.put(userName, account);
        	accountMap.put(password, account);
        	accountMap.put(pNumber, account);
        	break;
      
       
        case "L":
        	Views.accountLoginWindow();
        	System.out.println("Enter Username: ");
        	String username = s.next();
        	System.out.println("Enter Password: ");
        	String pass = s.next();
        	if(accountMap.containsKey(username)&& accountMap.containsKey(pass)) {
        		
        	}
        	else {
        		System.out.println("Incorrect Input, please select another choice");
        		continue;
        	}
        	
        	
        	Views.postViewWindow(postList);
        	
        	userInput = s.next();
        	
        	while(true) {
        	switch(userInput) {        	        
        	
        	case "+":
               	Views.newPostWindow();
               	userInput = s.next();
               	continue;
        
            case "A":
            	Views.displayTextArtOptions();
            	userInput = s.next();
            	//userInput = choice
            	Views.postViewWindow(postList);
            	userInput = s.next();
            	
            	continue;
           	
            case "T":
            	System.out.println("Please write your text post: ");
            	userInput = s.next();
            	//userInput = text post
            	Views.postViewWindow(postList);
            	userInput = s.next();
            	
            	continue;
           	
            case "Q":
            	System.out.println("Application closed.");
        //    	userInput = "";
            	break;
            	
            case "L": 
            	System.out.println("Successfully logged out!");
            	break;
           	
           	default:
           		System.out.println("Incorrect Input, please select another choice");
           		userInput = s.next();
        	}
        	break;
        	}
       	
        case "Q":
        	System.out.println("Application closed.");
   //     	userInput = "";
        	break;
       	
       	default:
       		System.out.println("Incorrect Input, please select one of the available options");
       		userInput = s.next();
        }   
        
        close(s);
    }
    }
    
	private static void close(Scanner s) {
		return;		
	}
	
}