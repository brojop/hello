package unl.soc;

import java.time.LocalDateTime;


public class TextPost extends Post implements PostContentFormatter {
	
private String wordPost;
public TextPost(String wordPost) {
	this.setWordPost(wordPost);
}
	
	
	public String getWordPost() {
		return wordPost;
	}
	public void setWordPost(String wordPost) {
		this.wordPost = wordPost;
	}


@Override
public String getFormattedContent() {
	String post = "" + tag();
	return post;}
}
