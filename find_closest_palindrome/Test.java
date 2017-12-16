import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"123", "9", "99", "999", "10987", "10001",
					   "10000", "1000", "1001", "10002", "30002",
					   "3002"};
		for (String s: ss) {
			System.out.println(s + ": " + solver.nearestPalindromic(s));
		}
	}
}
