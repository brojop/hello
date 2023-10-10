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
       // Views.mainWindow();
        Views.mainWindow();

        //if(make sure an account doesn't exist when creating it)
        Views.accountRegistrationWindow();
        //currentAccount = new Account();
        //accounts.put(userName, new Account(userName, password, phoneNumber))
        
        //if(make sure an account exists when trying to login)
        Views.accountLoginWindow();
        //if(currentAccount = "existing account") {
        //currentAccount = account logging in
        //else{
        //system.out.println("Username or password wrong!")
        
        //if(currentAccount != null)
        Views.postViewWindow(postList);
       
        //read an input if user decides to post
       	Views.newPostWindow();
       	//if(user decides to post text)
       	//read in text and add to postList
       	
       	//if(user decides to post art)
       	Views.displayTextArtOptions();
       	//read in no of art chosen by user and add to postList
       	
    }

}