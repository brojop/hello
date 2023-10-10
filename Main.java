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

        //if(make sure an account isn't created)
        Views.accountRegistrationWindow();
        //currentAccount = new Account();
        
        //if(make sure an account exists when trying to login)
        Views.accountLoginWindow();
        //currentAccount = "existing account" 
        
        Views.postViewWindow(postList);
       	Views.newPostWindow();
       	Views.displayTextArtOptions();
    }

}