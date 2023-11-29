package unl.soc;

import java.time.LocalDateTime;

public class Post {
	private int postID;
	private int userID;
	private String postText;
	private LocalDateTime postTime;

	public Post(int postID, int userID, String postText, LocalDateTime postTime) {
		super();
		this.postID = postID;
		this.userID = userID;
		this.postText = postText;
		this.postTime = postTime;
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

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

}
