import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String[] strs = {"a","b"};
		String[] strs = {"aa", "a"};
		String ret = solver.longestCommonPrefix(strs);

		System.out.println(ret);
	}
}
