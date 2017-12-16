import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"a", "ab", "aba", "Aa", "AaA"};
		for (String s: ss) {
			System.out.print(s + ": ");
			System.out.println(solver.longestPalindrome(s));
		}
	}
}
