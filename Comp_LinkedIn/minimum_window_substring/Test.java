import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		/*String s = "a";
		String t = "a";*/

		/*String s = "cabwefgewcwaefgcf";
		String t = "cae";*/

		String ret = solver.minWindow(s, t);

		System.out.println(ret);
	}
}
