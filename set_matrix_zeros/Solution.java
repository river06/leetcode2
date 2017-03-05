public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
		int n = matrix[0].length;

		// find if clear first row or column
		boolean clearFirstRow = false;
		boolean clearFirstCol = false;
		for( int i=0; i<m; i++){
			if( matrix[i][0]==0 ) {
				clearFirstCol = true;
				break;
			}
		}

		for( int j=0; j<n; j++ ) {
			if( matrix[0][j]==0 ) {
				clearFirstRow = true;
				break;
			}
		}

		// find setting zeros to remaining matrix
		for( int i=1; i<m; i++ ) {
			for( int j=1; j<n; j++ ) {
				if( matrix[i][j] == 0 ) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// set zeros
		for( int i=1; i<m; i++ ) {
			if( matrix[i][0] == 0 ) {
				for( int j=1; j<n; j++ ) {
					matrix[i][j] = 0;
				}
			}
		}

		for( int j=1; j<n; j++ ) {
			if( matrix[0][j]==0) {
				for( int i=1; i<m; i++ ) {
					matrix[i][j] = 0;
				}
			}
		}

		if( clearFirstRow ) {
			for( int j=0; j<n; j++ ){ matrix[0][j]=0; }
		}
		if( clearFirstCol ) {
			for( int i=0; i<m; i++ ){ matrix[i][0]=0; }
		}
    }
}
