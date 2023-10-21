package unl.soc;

import java.time.LocalDateTime;
import java.util.*;

public class TextArtPost extends Post implements PostContentFormatter {
	public final static List<String[]> OPTIONS;
    public String textArt;
    public TextArtPost(String textArt) {
    	this.textArt= textArt;
    }
    
    public String getTextArt() {
		return textArt;
	}


	public void setTextArt(String textArt) {
		this.textArt = textArt;
	}

	static { // initialize when the class is loaded
    	OPTIONS = initTextArtOptions();
    }
    
    public static List<String[]> initTextArtOptions(){
    	List<String[]> textArts = new ArrayList<>();
    	String[] bear = {
    			"   ▄▀▀▀▄▄▄▄▄▄▄▀▀▀▄   ",
    			"   █▒▒░░░░░░░░░▒▒█   ",
    			"    █░░█░░░░░█░░█    ",
    			"  ▄▄ █░░░▀█▀░░░█  ▄▄ ",
    			"█░░█─▀▄░░░░░░░▄▀─█░░█"};
    	textArts.add(bear);
    	String[] welcome = {
    			"█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█",
    			"█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█",
    			"█░░║║║╠─║─║─║║║║║╠─░░█",
    			"█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█",
    			"█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█"};
    	textArts.add(welcome);
    	String[] phone = {
    			"  ▄▄██████▄▄",
    			"▄██▀▄█▄▄█▄▀██▄",
    			"▀▀▀▄██▀▀██▄▀▀▀",
    			" ▄███─██─███▄",
    			" █████▄▄█████"};
    	textArts.add(phone);
    	String[] smile = {
    			"╔══╗░░░░╔╦╗░░╔═════╗",
    			"║╚═╬════╬╣╠═╗║░▀░▀░║",
    			"╠═╗║╔╗╔╗║║║╩╣║╚═══╝║",
    			"╚══╩╝╚╝╚╩╩╩═╝╚═════╝"};
    	textArts.add(smile);
    	return textArts;
    }
    

	@Override
	public String getFormattedContent() {
		String post = "textArts" + tag();
		return post;
	}

}