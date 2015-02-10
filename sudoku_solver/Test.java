public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		char[][] board = new char[9][9];
		int[][] intboard = {{5,3,0,0,7,0,0,0,0},
							{6,0,0,1,9,5,0,0,0},
							{0,9,8,0,0,0,0,6,0},
							{8,0,0,0,6,0,0,0,3},
							{4,0,0,8,0,3,0,0,1},
							{7,0,0,0,2,0,0,0,6},
							{0,6,0,0,0,0,2,8,0},
							{0,0,0,4,1,9,0,0,5},
							{0,0,0,0,8,0,0,7,9}};

		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(intboard[i][j] == 0) {
					board[i][j] = '.';
				} else {
					for(char c='1'; c<='9'; c++) {
						if(intboard[i][j] == c - '0') {
							board[i][j] = c;
							break;
						}
					}
				}
			}
		}
		printBoard(board);
		
		solver.solveSudoku(board);

		System.out.println(" ");
			
		printBoard(board);
	}

	public static void printBoard(char[][] board) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print( board[i][j] );
				System.out.print( "|" );
			}
			System.out.println(" ");
		}
	}
}