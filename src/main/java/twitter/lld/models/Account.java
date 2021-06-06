package twitter.lld.models;

import twitter.lld.constants.AccountType;
import twitter.lld.constants.Permission;
import twitter.lld.constants.Status;

public class Account {
	
	private AccountType accountType;
	
	private Status status;
	
	
	public void viewTweet(Tweet tweet) {
		System.out.println(tweet.describe());
	}

	public boolean hasPermission(Permission p) {
		
		return status == Status.ACTIVE && accountType.hasPermission(p);
	}

}
