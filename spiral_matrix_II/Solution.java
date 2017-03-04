public class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1;
		int[][] ret = new int[n][n];
		int left = 0;
		int right = n-1;
		int top = 0;
		int bottom = n-1;

		while( left<=right && top<=bottom ) {
			for( int j=left; j<=right; j++) {
				ret[top][j] = num++;
			}
			for( int i=top+1; i<=bottom; i++ ) {
				ret[i][right] = num++;
			}
			for( int j=right-1; j>=left; j-- ) {
				ret[bottom][j] = num++;
			}
			for( int i=bottom-1; i>=top+1; i-- ) {
				ret[i][left] = num++;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return ret;
    }
}
