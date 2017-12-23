import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*char[][] board = {
			{'X', 'X', 'X', 'X'},
			{'X', 'O', 'O', 'X'},
			{'X', 'X', 'O', 'X'},
			{'X', 'O', 'X', 'X'}
		};*/
		//char[][] board = {{'O'}};
		char[][] board = {{'X', 'O','X', 'O'}};
		solver.solve(board);

		for (char[] line: board) {
			System.out.println(Arrays.toString(line));
		}
	}
}
