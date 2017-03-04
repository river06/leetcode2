public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] nPath = new int[m][n];

		nPath[0][0] = (obstacleGrid[0][0]==0) ? 1 : 0;

		for(int i=1; i<m; i++) {
			nPath[i][0] = obstacleGrid[i][0]==0 ? nPath[i-1][0] : 0;
		}
		for(int j=1; j<n; j++) {
			nPath[0][j] = obstacleGrid[0][j]==0 ? nPath[0][j-1] : 0;
		}

		for( int i=1; i<m; i++ ) {
			for( int j=1; j<n; j++ ) {
				if( obstacleGrid[i][j] == 1) {
					nPath[i][j] = 0;
				} else {
					nPath[i][j] = nPath[i-1][j] + nPath[i][j-1];
				}
			}
		}
		return nPath[m-1][n-1];
    }
}
