public class Solution {
	/**
	 * O(m+n) solution. Search form top right.
	 * Left row is smaller than the corner
	 * Bottom column is larger than the corner
	 * Therefore, we can always dischard one row or column
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0 ) {
			return false;
		}
		int i = 0;
		int j = matrix[0].length - 1;
		while( i<=matrix.length-1 && j>=0 ) {
			int corner = matrix[i][j];
			if( corner == target ) {
				return true;
			} else if ( target < corner ) {
				j--;
			} else {
				i++;
			}
		}
		return false;
    }
}
