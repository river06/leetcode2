import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*String s = "leetcode";
		String[] dict = {
			"leet"
			};*/
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] dict = {
			"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa",
			"aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"
		};
		List<String> wordDict = new LinkedList<String>();
		for (String word: dict) { wordDict.add(word); }
		System.out.println(solver.wordBreak(s, wordDict));
	}
}
