import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
		int nIslands = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return nIslands;
		}

		int m = grid.length;
		int n = grid[0].length;

		boolean[][] isSeen = new boolean[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (grid[i][j] == '1' && !isSeen[i][j]) {
					nIslands++;
					
					exploreIsland(i, j, m, n, isSeen, grid);
				}
			}
		}
		return nIslands;
    }

	private void exploreIsland(int i, int j, int m, int n,
							   boolean[][] isSeen, char[][] grid) {
		isSeen[i][j] = true;

		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(i*n + j);
		int[][] delta = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
		while (!q.isEmpty()) {
			int pos = q.poll();
			int ii = pos/n;
			int jj = pos%n;
			for (int k=0; k<delta.length; k++) {
				int ni = ii+delta[k][0];
				int nj = jj+delta[k][1];
				if (ni >=0 && ni < m && nj >= 0 && nj < n &&
					grid[ni][nj] == '1' && !isSeen[ni][nj]) {
					q.offer( (ni)*n + nj );
					isSeen[ni][nj] = true;
				}
			}
		}
	}
}
