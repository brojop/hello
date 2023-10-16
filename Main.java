package unl.soc;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();
        //fix accounts
        Account currentAccount = null;
        //current account shouldn't be null
        List<Post> postList = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String userInput = s.next();
        

        //make sure they don't all print at once when running
       // mainWindow
        
        Views.mainWindow();

        //if(make sure an account doesn't exist when creating it)
        //if(userInput = R) {
        if(userInput != "Q") {
        switch(userInput) {
        case "R":
        	Views.accountRegistrationWindow();
        	break;
        //}
        //currentAccount = new Account();
        //accounts.put(userName, new Account(userName, password, phoneNumber))
        
        //if(make sure an account exists when trying to login)
        //if(userInput == "L") {
        case "L":
        	Views.accountLoginWindow();
        	break;
        //}
        //read in username and password to determine account logging in
        //if(currentAccount = an existing account) {
        //currentAccount = account logging in
        //else{
        //system.out.println("Username or password wrong!")
        
       // if(currentAccount != null) {
        
     //   Views.postViewWindow(postList);
        //}
        //read an input if user decides to post
        //if(userInput == "+") {
        case "+":
           	Views.newPostWindow();
           	break;
       // }
       	//if(user decides to post text)
       	//read in text and add to postList
       	
       	//if(user decides to post art)
       	//if(userInput == "A") {
        case "A":
       	Views.displayTextArtOptions();
       	break;
       	
       	default:
       		System.out.println("Incorrect Input, please select another choice");
       	//}
       	//read in no of art chosen by user and add to postList
        }
    }
    }
}