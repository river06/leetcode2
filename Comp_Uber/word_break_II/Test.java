import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String s = "ab";
		/*List<String> dict = new ArrayList<String>();

		dict.add("a");
		dict.add("b");*/
		// dict.add("and");
		// dict.add("sand");
		// dict.add("dog");

		String s = "catsanddog";
		String[] dictA = {"cat", "cats", "and", "sand", "dog"};
		List<String> dict = new ArrayList<String>();
		for (String word: dictA) { dict.add(word); }

		List<String> ret = solver.wordBreak(s, dict);
		for(int i=0;i<ret.size(); i++) {
			System.out.println( ret.get(i) );
		}
	}
}
