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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVisibilityList() {
		return visibilityList;
	}

	public void setVisibilityList(String visibilityList) {
		this.visibilityList = visibilityList;
	}

}