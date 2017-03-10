public class Solution {
    public int maximalSquare(char[][] matrix) {
        if( matrix==null || matrix.length==0 || matrix[0].length==0 ) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] square = new int[m][n];
		int ret = 0;
		for( int i=0; i<m; i++) {
			square[i][0] = matrix[i][0]-'0';
			if( square[i][0]==1 ) { ret = 1;}
		}
		for( int j=0; j<n; j++ ) {
			square[0][j] = matrix[0][j]-'0';
			if( square[0][j]==1 ) { ret = 1;}
		}

		for( int i=1; i<m; i++) {
			for( int j=1; j<n; j++) {
				if(matrix[i][j] == '0') {
					square[i][j] = 0;
				} else {
					int tmp = Math.min(square[i-1][j], square[i][j-1]);
					tmp = Math.min(tmp, square[i-1][j-1]);
					square[i][j] = (tmp+1);
					ret = Math.max( square[i][j]*square[i][j], ret);
				}
			}
		}

		return ret;
				
    }
}
