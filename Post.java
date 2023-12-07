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

	public int getPostID() {
		return postID;
	}

	public void setPostID(int postID) {
		this.postID = postID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public static String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		Post.postTime = postTime;
	}

}