import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] dictA = {
			"cat", "bat", "rat"
		};
		List<String> dict = new LinkedList<String>();
		for (String word: dictA) {
			dict.add(word);
		}

		String sentence = "the cattle was rattled by the battery";

		String ret = solver.replaceWords(dict, sentence);
		System.out.println(ret);
	  
	}
}
