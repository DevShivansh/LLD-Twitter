package twitter.lld.models;

import java.util.ArrayList;
import java.util.List;

public class CommentThread extends ArrayList<Comment> {

	private String threadId;

	public CommentThread(String threadId) {
		this.threadId = threadId;
	}
	
	
	public List<Comment> comments(){
		return this;
	}
	
	
	
}