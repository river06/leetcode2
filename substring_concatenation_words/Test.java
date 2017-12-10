import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"barfoothefoobarman", "barfoo", "barfoobar",
					   "barfootheboobar", "barfoothefoobar", "barfooafoobar"};
		String[] words = {"foo", "bar"};
		for (String s: ss) {
			List<Integer> ret = solver.findSubstring(s, words);
			System.out.println(s);
			System.out.println(ret);
			System.out.println("---------------------");
		}

		String s2 = "";
		String[] words2 = {""};
		List<Integer> ret2 = solver.findSubstring(s2, words2);
		System.out.println(ret2);
	}
}
