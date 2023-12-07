package unl.soc;

public class Post {
	private int postID;
	private int userID;
	private String postText;
	private static String postTime;

	public Post(int postID, int userID, String postText, String postTime) {
		super();
		this.postID = postID;
		this.userID = userID;
		this.postText = postText;
		Post.postTime = postTime;
	}

	// get the PostID
	public int getPostID() {
		return postID;
	}

	// sets the PostID
	public void setPostID(int postID) {
		this.postID = postID;
	}

	// get the UserID
	public int getUserID() {
		return userID;
	}

	// sets the UserID
	public void setUserID(int userID) {
		this.userID = userID;
	}

	// get the text that the user has typed
	public String getPostText() {
		return postText;
	}

	// sets what the user typed
	public void setPostText(String postText) {
		this.postText = postText;
	}

	// gets the time when the post was posted
	public static String getPostTime() {
		return postTime;
	}

	// sets the time of the post
	public void setPostTime(String postTime) {
		Post.postTime = postTime;
	}

}