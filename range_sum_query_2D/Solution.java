import java.util.*;
class NumMatrix {
	int[][] sum;
    public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			System.out.println("meaningless edge cases");
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
        this.sum = new int[m+1][n+1];
		for (int i=1; i<=m; i++) {
			for (int j=1; j<=n; j++) {
				sum[i][j] = matrix[i-1][j-1] + sum[i-1][j] +
					sum[i][j-1] - sum[i-1][j-1];
			}
		}
		/*for (int[] row: sum) {
			System.out.println(Arrays.toString(row));
		}*/
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1]
			+ sum[row1][col1];
    }
}
