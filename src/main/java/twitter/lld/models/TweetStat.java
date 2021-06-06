package twitter.lld.models;

public class TweetStat implements Comparable<TweetStat> {

	private Tweet tweet;
	
	private boolean isSeen = false;

	public TweetStat(Tweet tweet) {
		
		this.tweet = tweet;
	}
	
	public Tweet tweet() {
		return tweet;
	}

	@Override
	public int compareTo(TweetStat t2) {

		if (tweet.isCelebTweet() && t2.tweet.isCelebTweet()
				|| (!tweet.isCelebTweet() && !t2.tweet.isCelebTweet()))
			return seenCheck(t2);
		else
			return tweet.isCelebTweet() ? -1 : 1;
	}
	
	private int seenCheck(TweetStat otherTweet) {
		if ((!this.isSeen && !otherTweet.isSeen) || (this.isSeen && otherTweet.isSeen))
			return this.tweet.isBefore(otherTweet.tweet) ? -1 : 1;
		else {
			return this.isSeen ? -1 : 1;
		}
	}
	
}
