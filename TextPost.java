package unl.soc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
		
		LocalDateTime postTime = LocalDateTime.now();
		
		 postTime.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
	
		return wordPost + postTime + postAccount; 
				}
	}