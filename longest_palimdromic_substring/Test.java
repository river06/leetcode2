import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		// String s = "babad";
		// String s = "cbbbd";
		String s = "cbbd";
		String ret = solver.longestPalindrome(s);
		System.out.println(ret);
	}
}
