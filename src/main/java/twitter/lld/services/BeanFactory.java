package twitter.lld.services;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory<K> {
	
	private static Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();
	
	static {
		beanMap.put(UserService.class, new UserService());
		beanMap.put(TweetService.class, new TweetService());
	}
	
	
	public K get(K k) {
		return (K) beanMap.get(k);
	}

}
