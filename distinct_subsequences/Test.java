import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "ABCDE";
		String t = "ACE";
		int ret = solver.numDistinct(s,t);
		System.out.println(ret);
	}
}
