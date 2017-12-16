import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		for (int i=1; i<8; i++) {
			System.out.print(i + ": ");
			System.out.println(solver.largestPalindrome(i));
		}
	}
}
