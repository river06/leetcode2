import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s1 = "ab";
		String s2 = "eidbaooo";
		/*String s1 = "ab";
		String s2 = "eidboaoo";*/
		/*String s1 = "ab";
		String s2 = "a";*/
		boolean ret = solver.checkInclusion(s1, s2);
		System.out.println(ret);
	}
}
