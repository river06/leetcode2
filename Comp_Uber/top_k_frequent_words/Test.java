import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;

		List<String> ret = solver.topKFrequent(words, k);

		System.out.println(ret);
	}
}
