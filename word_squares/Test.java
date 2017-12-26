import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String[] words = {"area","lead","wall","lady","ball"};
		//String[] words = {"abat","baba","atan","atal"};
		String[] words = {"aaa"};
		List<List<String>> ret = solver.wordSquares(words);

		for (List<String> square: ret) {
			for (String word: square) {
				System.out.println(word);
			}
			System.out.println("---------------");
		}
	}
}
