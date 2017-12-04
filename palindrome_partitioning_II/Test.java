import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] tests = {"", "aab", "a", "ab", "aba"};
		for (String s: tests) {
			int ret = solver.minCut(s);

			System.out.println(s + ": needs: " + ret);
		}
		
	}
}
