package unl.soc;

import java.time.LocalDateTime;

public class TextPost extends Post implements PostContentFormatter {

	@Override
	public String getFormattedContent() {
		String post = "" + tag();
		return post;
	}

}
