package twitter.lld.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import twitter.lld.constants.Constants;
import twitter.lld.constants.Permission;
import twitter.lld.interfaces.Follower;
import twitter.lld.interfaces.TweetingUser;

public class RegisteredAccount implements Follower, TweetingUser {

	private Account account;

	private User user;

	private List<Follower> followers;

	private Wall feedWall;

	private TimeLine timeline;

	public RegisteredAccount(Account account, User user) {
		this.account = account;
		this.user = user;
		feedWall = new Wall();
		timeline = new TimeLine();
	}

	public void viewTweet(Tweet tweet) {
		account.viewTweet(tweet);
	}

	public void postTweet(Tweet tweet) {
		
		if(!account.hasPermission(Permission.POST))
			throw new RuntimeException("Account doesnt have necesssary permissions to POST a tweet!");
		
		timeline.add(tweet);
		followers.stream().forEach(follower -> follower.listenTweet(tweet));
	}
	
	public void commentOnTweet(Tweet tweet, String threadId, String comment) {
		
		tweet.comment(threadId, new Comment(this, comment));
		
	}

	public void follow(RegisteredAccount account) {
		account.followers.add(this);
	}

	public void unFollow(RegisteredAccount account) {
		account.followers.remove(this);
	}

	@Override
	public void listenTweet(Tweet tweet) {
		feedWall.add(new TweetStat(tweet));

	}

	public Boolean isCelebrity() {
		return followers.size() >= Constants.MIN_FOLLOWS_TO_BE_CELEB;
	}

	
	public List<TweetStat> viewFeedsOnWall() {
		return feedWall.viewAll();
	}
	
	public List<Tweet> viewTimeline(){
		return new ArrayList<Tweet>(timeline);
	}

	@Override
	public String userId() {
		return user.userId();
	}
}
