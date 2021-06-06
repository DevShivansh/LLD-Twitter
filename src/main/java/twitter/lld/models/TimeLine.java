package twitter.lld.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import twitter.lld.TweetSorter;
import twitter.lld.constants.Sort;

public class TimeLine extends HashSet<Tweet> {
	
	
	public List<Tweet> sort(Sort sortKey){
		
		List<Tweet> tweets = new ArrayList<Tweet>(this);
		tweets.sort(TweetSorter.get(sortKey));
		return tweets;
		
	}
	
	public void modifyTweet(Tweet t) {
		this.add(t);
	}

	
}
