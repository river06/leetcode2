public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] nPath = new int[m][n];

		for(int i=0; i<m; i++){ nPath[i][0] = 1; }
		for(int j=0; j<n; j++){ nPath[0][j] = 1; }

		for( int i=1; i<m; i++ ) {
			for( int j=1; j<n; j++ ) {
				nPath[i][j] = nPath[i-1][j] + nPath[i][j-1];
			}
		}
		return nPath[m-1][n-1];
    }
}
