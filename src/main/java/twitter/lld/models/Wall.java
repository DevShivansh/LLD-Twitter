package twitter.lld.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wall extends ArrayList<TweetStat> {

	
	
	@Override
	public boolean add(TweetStat e) {
		super.add(e);
		Collections.sort(this);
		return true;
	}
	
	
	public List<TweetStat> viewAll(){
		return this;
	}
	
	
}
