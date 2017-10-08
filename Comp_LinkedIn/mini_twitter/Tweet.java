/**
 * Definition of Tweet:
 */
 public class Tweet {
     public int id;
     public int user_id;
     public String text;
	 public Tweet(int id, int user_id, String text) {
		 this.user_id = id;
		 this.text = text;
		 this.id = user_id;
	 }
     public static Tweet create(int user_id, String tweet_text) {
         // This will create a new tweet object,
         // and auto fill id
		 return new Tweet(user_id, user_id, tweet_text);
     }
 }
