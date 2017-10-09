/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */

import java.util.*;
public class MiniTwitter {

	/*
	 * Helper class
	 */
	class TimedTweet {
		public int timeStamp;
		public Tweet tweet;
		public TimedTweet(int timeStamp, Tweet tweet) {
			this.timeStamp = timeStamp;
			this.tweet = tweet;
		}
	}

	/*
	 * Constants
	 */
	// Number of tweets we keep track of
	private final int NUM_TWEET = 10;
	
	/*
	 * Properties
	 */
	// Maps from user Id to friends' Ids 
	private Map<Integer, Set<Integer>> friendMap;

	// Maps from user Id to user's tweets
	private Map<Integer, List<TimedTweet>> userTweets;
	
	// Used to mimic time stamp
	private int timeStamp;

	/* 
	 * Constructors
	 */
    public MiniTwitter() {
        this.friendMap = new HashMap<Integer, Set<Integer>>();
		this.userTweets = new HashMap<Integer, List<TimedTweet>>();
		this.timeStamp = 0;
    }

	/*
	 * Public Functions
	 */

    /**
	 * Creates a tweet. Create a user if user does not exist.
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        Tweet tweet = Tweet.create(user_id, tweet_text);
		if (!userTweets.containsKey(user_id)) {
			userTweets.put(user_id,  new LinkedList<TimedTweet>());
		}
		
		this.timeStamp++;
		List<TimedTweet> timedTweet = userTweets.get(user_id);
		timedTweet.add(0, new TimedTweet(timeStamp, tweet));
		if (timedTweet.size() > this.NUM_TWEET) {
			timedTweet.remove(this.NUM_TWEET);
		}
		return tweet;
    }

    /**
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
		List<Tweet> newsFeed = new LinkedList<Tweet>();
		if (userTweets.containsKey(user_id)) {
			for (TimedTweet timedTweet: userTweets.get(user_id)) {

				newsFeed.add(timedTweet.tweet);
			}
		}
		return newsFeed;
    }

    /**
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        List<TimedTweet> timeline = new LinkedList<TimedTweet>();
		if (userTweets.containsKey(user_id)) {
			timeline = mergeTimeline(timeline, userTweets.get(user_id));
		}
		
		if (friendMap.containsKey(user_id)) {
			for (int friend_id: friendMap.get(user_id)) {
				if (userTweets.containsKey(friend_id)) {
					timeline = mergeTimeline(timeline, userTweets.get(friend_id));
				}
			}
		}
		List<Tweet> tweets = new LinkedList<Tweet>();
		for (TimedTweet timedTweet: timeline) {
			tweets.add(timedTweet.tweet);
		}
		return tweets;
    }

    /**
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        if (!friendMap.containsKey(from_user_id)) {
			friendMap.put(from_user_id, new HashSet<Integer>());
		}
		friendMap.get(from_user_id).add(to_user_id);
    }

    /**
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
		if (friendMap.containsKey(from_user_id)) {
			friendMap.get(from_user_id).remove(to_user_id);
		}
    }

	/*
	 * Private functions
	 */
	private List<TimedTweet> mergeTimeline(List<TimedTweet> t1, List<TimedTweet> t2) {
		List<TimedTweet> tm = new LinkedList<TimedTweet>();
		int p1 = 0;
		int p2 = 0;
		while (p1 < t1.size() && p2 < t2.size() && tm.size() < NUM_TWEET) {
			if (t1.get(p1).timeStamp > t2.get(p2).timeStamp) {
				tm.add(t1.get(p1));
				p1++;
			} else {
				tm.add(t2.get(p2));
				p2++;
			}
		}
		int tmSize = tm.size();
		if (p1 == t1.size()) {
			for (int pm = p2; pm < Math.min(t2.size(), p2+NUM_TWEET-tmSize); pm++) {
				tm.add(t2.get(pm));
			}
		}
		if (p2 == t2.size()) {
			for (int pm = p1; pm < Math.min(t1.size(), p1+NUM_TWEET-tmSize); pm++) {
				tm.add(t1.get(pm));
			}
		}
		return tm;
	}
}
