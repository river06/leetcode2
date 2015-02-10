import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String s = "ab";
		Set<String> dict = new HashSet<String>();

		dict.add("a");
		dict.add("b");
		// dict.add("and");
		// dict.add("sand");
		// dict.add("dog");

		ArrayList<String> ret = solver.wordBreak(s, dict);
		for(int i=0;i<ret.size(); i++) {
			System.out.println( ret.get(i) );
		}
	}
}