import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		/*String word1 = "coding";
		String word2 = "practice";*/
		String word1 = "makes";
		String word2 = "coding";
		int ret = solver.shortestDistance(words, word1, word2);
		System.out.println(ret);
	}
}
