package unl.soc;

public class Account {
	
	private String userName;
	private String password;
	private String phoneNumber;
	
	public Account() {
	}
	
	public Account(String userName, String password, String phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

    public String getUsername() {
        return this.userName.toString();
    }
    
    public String getPassword() {
    	return this.password.toString();
    }
    
    public String getPhoneNumber() {
    	return this.phoneNumber.toString();
    }
    
    public void setUsername(String username) {
    	this.userName = username;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }
    
}
