import java.util.*;
public class Test {
	public static void main(String[] args) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");

		String[] words = {"pad", "bad", ".ad", "b.."};
		for (String word: words) {
			boolean ret = dict.search(word);
			System.out.println(word);
			System.out.println(ret);
		}
		
	}
}
