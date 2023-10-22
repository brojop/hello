package unl.soc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Account> accountMap = new HashMap<>();
        
        //current account shouldn't be null
        List<Post> postList = new ArrayList<>();
        List<String> outputList = new ArrayList<>();
        new TextArtPost("");
        List<String[]> options = TextArtPost.OPTIONS;

        
        

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
        		System.out.println("Incorrect username or password, please try again");
        		continue;
        	}
        	
        	
        	Views.postViewWindow(postList);
        	for(String history : outputList) {
        		System.out.println(history);
        		System.out.println();
        		System.out.println();
        	}
        	userInput = s.next();
        	
        	while(true) {
        	switch(userInput) {        	        
        	
        	case "+":
               	Views.newPostWindow();
               	for(String history : outputList) {
            		System.out.println(history);
            		System.out.println();
            		System.out.println();
            	}
               	userInput = s.next();
               	continue;
        
            case "A":
            	Views.displayTextArtOptions();
            	String choice = s.next();
            	
            	while(true) {
            		switch(choice) {
            		
            		case "0":
            			String[] bearArt = options.get(0); 
            			for(String artPost : bearArt)
            			System.out.println(artPost);
            			String currentAccount0 = username;
            			System.out.println(currentAccount0);
            			
            			
            			
            			break;
            			
            		case "1":
            			String[] welcome = options.get(1); 
            			for(String artPost : welcome)
            			System.out.println(artPost);
            			String currentAccount1 = username;
            			System.out.println(currentAccount1);
            			break;
            			
            		case "2":
            			String[] phone = options.get(2); 
            			for(String artPost : phone)
            			System.out.println(artPost);
            			String currentAccount2 = username;
            			System.out.println(currentAccount2);
            			break;
            			
            		case "3":
            			String[] smile = options.get(3); 
            			for(String artPost : smile)
            			System.out.println(artPost);
            			String currentAccount3 = username;
            			System.out.println(currentAccount3);
            			//postList.add(smile);
            			break;
            		}
            		break;
            	}
            	
            	Views.postViewWindow(postList);
            	for(String history : outputList) {
            		System.out.println(history);
            		System.out.println();
            		System.out.println();
            	}
            	
            	userInput = s.next();
            	
            	continue;
           	
            case "T":
            	System.out.println("Please write your text post: ");
            	String firstWord=s.next();
            	String words = s.nextLine();
            	Views.postViewWindow(postList);
            	String currentAccount = username;
            	System.out.println(firstWord+words);
            	System.out.println(currentAccount);
            	outputList.add(firstWord+words);
            	userInput = s.next();
            	
            	continue;
           	
            case "Q":
            	System.out.println("Application successfully closed");
            	return;
            	
            	
            case "L": 
            	System.out.println("Successfully logged out!");
            	break;
           	
           	default:
           		System.out.println("Incorrect Input, please select another choice");
           		userInput = s.next();
           		continue;
        	}
        	break;
        	}
        break;
       	
        case "Q":
        	System.out.println("Application closed.");
        	return;
       	
       	default:
       		System.out.println("Incorrect Input, please select one of the available options");
       		userInput = s.next();
        }   
        
        close();
    }
    }
    
	private static void close() {
		return;		
	}
	
}