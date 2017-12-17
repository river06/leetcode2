import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String s = "aabbcc";
	//	String s = "aaabc";
		//String s = "aaadbbcc";
		String s = "a";
		int k = 2;
		//int k = 3;
		String ret = solver.rearrangeString(s, k);
		System.out.println(ret);
	}
}
