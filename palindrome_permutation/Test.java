import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"code", "aab", "aa", "carerac", "baa", "aabb"};
		for (String s: ss) {
			System.out.println(s);
			System.out.println(solver.canPermutePalindrome(s));
		}
	}
}
