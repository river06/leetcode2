public class Solution {
    public boolean exist(char[][] board, String word) {
        
		if(board==null || board.length==0 || board[0].length==0
		   || board.length*board[0].length<word.length() ) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;

		boolean[][] isVisited = new boolean[m][n];

		for( int i=0; i<m; i++ ) {
			for( int j=0; j<n; j++ ) {
				if( board[i][j] == word.charAt(0) ) {
					isVisited[i][j] = true;
					boolean ret = helper(board, isVisited, word, 1, i, j);
					if( ret == true ) { return true; }
					isVisited[i][j] = false;
				}
			}
		}

		return false;
    }

	private boolean helper(char[][] board, boolean[][] isVisited, String word, int idx, int i, int j) {
		if( idx == word.length() ) { return true; }
		int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for(int[] dd: d ) {
			int ii = i+dd[0];
			int jj = j+dd[1];
			if( ii >=0 && ii < board.length && jj >=0 && jj < board[0].length &&
				isVisited[ii][jj] != true && board[ii][jj] == word.charAt(idx) ) {
				isVisited[ii][jj] = true;
				boolean ret = helper(board, isVisited, word, idx+1, ii, jj);
				if( ret == true ) { return true; }
				isVisited[ii][jj] = false;
			}
		}

		return false;
					
	}
}
