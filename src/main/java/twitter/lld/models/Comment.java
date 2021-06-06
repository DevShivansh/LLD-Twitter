package twitter.lld.models;

import twitter.lld.interfaces.TweetingUser;

public class Comment {

	
	private TweetingUser tweeter;
	
	private String desc;

	public Comment(TweetingUser tweeter, String desc) {
		super();
		this.tweeter = tweeter;
		this.desc = desc;
	}
	
	
	public String showComment() {
		return tweeter.userId() + " : " + desc;
	}
	
}
