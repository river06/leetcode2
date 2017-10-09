import java.util.*;
public class Test {
	public static void main(String[] args) {
		MiniTwitter twitter = new MiniTwitter();
		/*twitter.postTweet(1, "message 1");
		twitter.postTweet(2, "message 2");
		twitter.postTweet(1, "message 3");*/

		for (int i=1; i<=11; i++) {
			twitter.postTweet(1, "("+i+")");
			twitter.postTweet(2, "["+i+"]");

		}

		int userId = 1;

		printNewsFeed(userId, twitter);
		printTimeline(userId, twitter);

		int user2 = 2;

		twitter.follow(2, 1);
		printNewsFeed(user2, twitter);
		printTimeline(user2, twitter);

		twitter.unfollow(2, 1);
		printNewsFeed(user2, twitter);
		printTimeline(user2, twitter);

		twitter.follow(1, 2);
		printNewsFeed(1, twitter);
		printTimeline(1, twitter);
	}

	public static void printNewsFeed(int userId, MiniTwitter twitter) {
		List<Tweet> newsFeed = twitter.getNewsFeed(userId);
		
		System.out.println("------ user: ["+userId + "] news feed ------");
		for (Tweet tweet: newsFeed) {
			System.out.println(tweet.text);
		}
		System.out.println("--------------------------------");
		System.out.println("");
	}

	public static void printTimeline(int userId, MiniTwitter twitter) {
		List<Tweet> newsFeed = twitter.getTimeline(userId);
		System.out.println("------ user: ["+userId + "] timeline ------");
		for (Tweet tweet: newsFeed) {
			System.out.println(tweet.text);
		}
		System.out.println("--------------------------------");
		System.out.println("");
	}
}
