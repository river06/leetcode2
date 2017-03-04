import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<Integer>();
		int nRow = matrix.length;
		if( nRow <= 0 ) { return ret; }
		int nCol = matrix[0].length;
		if( nCol <= 0 ) { return ret; }

		int left = 0;
		int right = nCol-1;
		int top = 0;
		int bottom = nRow-1;

		while( left<=right && top<=bottom ) {
			// top line
			for( int j=left; j<=right; j++) {
				ret.add( matrix[top][j] );
			}
			// right line
			for( int i=top+1; i<=bottom; i++ ) {
				ret.add( matrix[i][right] );
			}
			// bottom line
			if( top < bottom ) {
				for( int j=right-1; j>=left; j--) {
					ret.add( matrix[bottom][j] );
				}
			}
			// left line
			if( left < right ) {
				for( int i=bottom-1; i>top; i--) {
					ret.add( matrix[i][left] );
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return ret;
    }
}
