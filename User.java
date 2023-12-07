package unl.soc;

public class User {
	private int userID;
	private String username;
	private String password;
	private String visibilityList;

	public User(int userID, String username, String password, String visibilityList) {

		this.userID = userID;
		this.username = username;
		this.password = password;
		this.visibilityList = visibilityList;
	}

	// gets the UserID
	public int getUserID() {
		return userID;
	}

	// sets the UserID
	public void setUserID(int userID) {
		this.userID = userID;
	}

	// gets the Username
	public String getUsername() {
		return username;
	}

	// sets the Username
	public void setUsername(String username) {
		this.username = username;
	}

	// gets the Password
	public String getPassword() {
		return password;
	}

	// sets the Password
	public void setPassword(String password) {
		this.password = password;
	}

	// gets the Visibility
	public String getVisibilityList() {
		return visibilityList;
	}

	// sets the Visibility
	public void setVisibilityList(String visibilityList) {
		this.visibilityList = visibilityList;
	}

}