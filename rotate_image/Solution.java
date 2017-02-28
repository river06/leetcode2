public class Solution {
    public void rotate(int[][] matrix) {
        if( matrix.length==0 ) { return; }
		if( matrix[0].length==0 ) { return; }

		int n = matrix.length;

		for( int i=0; i<=(n-1)/2; i++ ) {
			for( int j=0; j<=n/2-1; j++ ) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}
    }
}
