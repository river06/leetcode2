import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] ss = {"aaaa", "aaaaa", "aaaaaaaaaa", "aabcaabcd"};

		for (String s: ss) {
			
			String ret = solver.encode(s);
			System.out.println(s + ": " + ret);
		}
	}
}
