import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		char[][] board = {
			{'o','a','a','n'},
			{'e','t','a','e'},
			{'i','h','k','r'},
			{'i','f','l','v'}
		};

		String[] words = {"oath","pea","eat","rain"};

		List<String> ret = solver.findWords(board, words);

		System.out.println(ret);
	}
}
