import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String[] words = {"bat", "tab", "cat"};
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		List<List<Integer>> ret = solver.palindromePairs(words);
		for (List<Integer> pair: ret) {
			System.out.println(words[pair.get(0)] + " | " +
							   words[pair.get(1)]);
			System.out.println(pair.get(0) + " | " + pair.get(1));
		}
	}
}
