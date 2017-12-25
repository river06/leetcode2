import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//String[] words = {"w","wo","wor","worl", "world"};
		String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

		String ret = solver.longestWord(words);

		System.out.println(ret);
	}
}
