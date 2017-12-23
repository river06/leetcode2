import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};*/
		/*String[][] pairs = {
			{"great", "good"}, {"fine", "good"},
			{"acting","drama"}, {"skills","talent"}
		};*/
		/*String[][] pairs = {
			{"great", "good"}, {"fine", "good"},
			{"acting","drama"}
		};*/

		String[] words1 = {"great"};
		String[] words2 = {"greatt"};
				
		String[][] pairs = {};
		boolean ret = solver.areSentencesSimilarTwo(words1, words2, pairs);

		System.out.println(ret);
	}
}
