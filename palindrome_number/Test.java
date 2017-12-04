import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] xs = {0, 1, 2, 10, 100, 101, 111, 123};
		for (int x: xs) {
			boolean ret = solver.isPalindrome(x);
			System.out.println(x + " is: " + ret);
		}
	}
}
