class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] isColUsed = new boolean[9][9];
		boolean[][] isRowUsed = new boolean[9][9];
		boolean[][] isGridUsed = new boolean[9][9];
		preProcess(isColUsed, isRowUsed, isGridUsed, board);

		backTracking(isColUsed, isRowUsed, isGridUsed, board, 0);
    }

	private void preProcess(boolean[][] isColUsed, boolean[][] isRowUsed,
							boolean[][] isGridUsed, char[][] board) {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (board[i][j] != '.') {
					char c = board[i][j];
					isRowUsed[i][c-'1'] = true;
					isColUsed[j][c-'1'] = true;
					isGridUsed[i/3*3 + j/3][c-'1'] = true;
				}
			}
		}
	}

	private boolean backTracking(boolean[][] isColUsed, boolean[][] isRowUsed,
								 boolean[][] isGridUsed, char[][] board,
								 int startIdx) {
		if (startIdx >= 81) { return true; }
		boolean isSolved = false;
		// find the first index to update
		int idx = startIdx;
		for (idx = startIdx; idx < 81; idx++) {
			int i = idx / 9;
			int j = idx % 9;
			if (board[i][j] == '.') {
				//back tracking here
				for (char c = '1'; c<='9'; c++) {
					if (isRowUsed[i][c-'1'] || isColUsed[j][c-'1'] ||
						isGridUsed[i/3*3 + j/3][c-'1']) {
						continue;
					}
					isRowUsed[i][c-'1'] = true;
					isColUsed[j][c-'1'] = true;
					isGridUsed[i/3*3 + j/3][c-'1'] = true;
					board[i][j] = c;
					if (backTracking(isColUsed, isRowUsed, isGridUsed, board, idx+1)) {
						isSolved = true;
						break;
					}
					isRowUsed[i][c-'1'] = false;
					isColUsed[j][c-'1'] = false;
					isGridUsed[i/3*3 + j/3][c-'1'] = false;
					board[i][j] = '.';
				}
							
				break;
			}
		}
		return isSolved | idx == 81;
	}
										  
}
