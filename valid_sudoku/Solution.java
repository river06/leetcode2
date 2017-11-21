import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] isRowUsed = new boolean[9][9];
	boolean[][] isColUsed = new boolean[9][9];
	boolean[][] isSqrUsed = new boolean[9][9];
	// loop through every grid
	for (int i=0; i<9; i++) {
	    for (int j=0; j<9; j++) {
		int num = -1;
		if (board[i][j] >= '1' && board[i][j] <= '9') {
		    num = board[i][j] - '0' - 1;
		}
		if (num != -1) {
		    int[] indices = findIndices(i, j);
		    if (isRowUsed[indices[0]][num] ||
			isColUsed[indices[1]][num] ||
			isSqrUsed[indices[2]][num]) {
			return false;
		    } else {
			isRowUsed[indices[0]][num] = true;
			isColUsed[indices[1]][num] = true;
			isSqrUsed[indices[2]][num] = true;
		    }
		}
	    }
	}
	return true;
    }
    private int[] findIndices(int i, int j) {
	int[] indices = new int[3];
	indices[0] = i;
	indices[1] = j;
	indices[2] = i/3*3 + j/3;
	return indices;
    }
}
