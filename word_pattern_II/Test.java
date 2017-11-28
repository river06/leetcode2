import java.util.*;
public class Test {
    public static void main(String[] args) {
	Solution solver = new Solution();
	//String pattern = "abab";
	//String str = "redblueredblue";
	String pattern = "aa";
	String str = "ab";
	boolean ret = solver.wordPatternMatch(pattern, str);
	System.out.println(ret);
    }
}
