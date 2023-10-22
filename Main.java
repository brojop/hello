package unl.soc;

import java.util.*;

public class Main {

    private static final Account currentAccount = null;

	public static void main(String[] args) {
        Map<String, Account> accountMap = new HashMap<>();
        
        
        List<Post> postList = new ArrayList<>();
        
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
        	for(Post art : postList) {
        		System.out.println(art);
        		System.out.println();
        		System.out.println();
        	}
        	userInput = s.next();
        	
        	while(true) {
        	switch(userInput) {        	        
        	
        	case "+":
               	Views.newPostWindow();
               	
            	for(Post art : postList) {
            		System.out.println(art);
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
            			for(String artPost : bearArt) {
            				TextArtPost art = new TextArtPost(artPost);
            				art.setUsername(currentAccount);
            				postList.add(art);
            			System.out.println(artPost);}
            			String currentAccount0 = username;
            			System.out.println(currentAccount0);
            			
            			
            			
            			break;
            			
            		case "1":
            			String[] welcome = options.get(1); 
            			for(String artPost : welcome) {
            				TextArtPost art = new TextArtPost(artPost);
            				art.setUsername(currentAccount);
            				postList.add(art);
            			System.out.println(artPost);}
            			String currentAccount1 = username;
            			System.out.println(currentAccount1);
            			
            			break;
            			
            		case "2":
            			String[] phone = options.get(2); 
            			for(String artPost : phone) {
            				TextArtPost art = new TextArtPost(artPost);
            				art.setUsername(currentAccount);
            				postList.add(art);
            			System.out.println(artPost);}
            			String currentAccount2 = username;
            			System.out.println(currentAccount2);
            			break;
            			
            		case "3":
            			String[] smile = options.get(3); 
            			for(String artPost : smile) {
            				TextArtPost art = new TextArtPost(artPost);
            				art.setUsername(currentAccount);
            				postList.add(art);
            			System.out.println(artPost);}
            			String currentAccount3 = username;
            			System.out.println(currentAccount3);
            			
            			break;
            		}
            		break;
            	}
            	
            	
            	Views.postViewWindow(postList);
            	for(Post art : postList) {
            		System.out.println(art);
            		System.out.println();
            		System.out.println();
            	}
            	
            	userInput = s.next();
            	
            	continue;
           	
            case "T":
            	System.out.println("Please write your text post: ");
            	String firstWord=s.next();
            	String words = s.nextLine();
            	String fullSentence = firstWord+words;
            	TextPost text = new TextPost(fullSentence);
            	postList.add(text);
            	Views.postViewWindow(postList);
            	String currentAccount = username;
            	 
            		
            	
            	System.out.println(fullSentence);
            	System.out.println(currentAccount);
            	
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