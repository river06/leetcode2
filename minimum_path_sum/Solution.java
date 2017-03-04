public class Solution {
    public int minPathSum(int[][] grid) {
        if( grid==null || grid.length<=0 || grid[0].length<=0 ) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int[][] pathSum = new int[m][n];

		pathSum[0][0] = grid[0][0];
		for(int i=1; i<m; i++) {
			pathSum[i][0] = pathSum[i-1][0]+grid[i][0];
		}

		for(int j=1; j<n; j++) {
			pathSum[0][j] = pathSum[0][j-1]+grid[0][j];
		}

		for( int i=1; i<m; i++ ){
			for( int j=1; j<n; j++ ) {
				int tmp = Math.min(pathSum[i-1][j], pathSum[i][j-1]);
				pathSum[i][j] = grid[i][j]+tmp;
			}
		}

		return pathSum[m-1][n-1];
		
    }
}
