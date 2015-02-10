public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		String[] pre_board = {"ABCE","SFCS","ADEE"};
		int m = pre_board.length;
		int n = pre_board[0].length();
		char[][] board = new char[m][n];
		for(int i=0; i<m; i++) {
			board[i] = pre_board[i].toCharArray();
		}

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(board[i][j]);
				System.out.print("|");
			}
			System.out.println(" ");
		}
		
		String word = "ABC";
		boolean ret = solver.exist(board, word);
		System.out.println(ret);
	}
}