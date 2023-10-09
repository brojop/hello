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
        if(currentAccount == null) {
            Views.mainWindow();

        }
        Views.accountRegistrationWindow();
        Views.accountLoginWindow();
        Views.postViewWindow(postList);
       	Views.newPostWindow();
       	Views.displayTextArtOptions();
    }

}