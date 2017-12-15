import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String s = "aabb";
		String[] ss = {"aabb", "ab", "aba", "aa", "abc", "aaaabbbb"};
		for (String s: ss) {
			System.out.println(s);
			List<String> ret = solver.generatePalindromes(s);
			System.out.println(ret);
			System.out.println("----------------");
		}
	}
}
