import java.util.*;
public class Test {
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "practice";
		/*String word1 = "makes";
		String word2 = "coding";*/
		WordDistance solver = new WordDistance(words);
		int ret = solver.shortest(word1, word2);
		System.out.println(ret);
	}
}
