public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if( matrix==null || matrix.length==0 || matrix[0].length == 0 ){
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;

		// binary search in rows
		int p1 = 0, p2 = m-1;
		while( p2-p1>1 ) {
			int pm = p1 + (p2-p1)/2;
			if( target < matrix[pm][0] ) {
				p2 = pm;
			} else {
				p1 = pm;
			}
		}
		int iRow;
		if( target < matrix[p1][0] ) {
			iRow = p1-1;
		} else if ( target>= matrix[p2][0] ) {
			iRow = p2;
		} else {
			iRow = p1;
		}

		if (iRow < 0 ) { return false; }

		p1 = 0;
		p2 = n-1;
		while( p1 <= p2 ) {
			int pm = p1 + (p2-p1)/2;
			if( matrix[iRow][pm] == target ) {
				return true;
			} else if ( target < matrix[iRow][pm] ) {
				p2 = pm-1;
			} else {
				p1 = pm+1;
			}
		}
		return false;
    }
}
