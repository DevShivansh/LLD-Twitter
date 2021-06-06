package twitter.lld;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import twitter.lld.constants.Sort;
import twitter.lld.models.Tweet;

public class TweetSorter {

	private static Comparator<Tweet> oldPrioritySortter = (t1, t2) -> { return t1.isBefore(t2) ? -1 : 1;};
	
	private static Comparator<Tweet> newPrioritySortter = (t1, t2) -> { return t1.isBefore(t2) ? 1 : -1;};
	
	private static Map<Sort, Comparator<Tweet>> sortMap = new HashMap<Sort, Comparator<Tweet>>();
	
	{
		sortMap.put(Sort.OLDEST, oldPrioritySortter);
		sortMap.put(Sort.NEWEST, newPrioritySortter);
		
	}
	
	public static Comparator<Tweet> get(Sort sort){
		return sortMap.get(sort);
	}
	
}
