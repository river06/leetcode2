class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // sqrt to find the column and rows
		int l = matrix[0][0];
		int r = matrix[matrix.length-1][matrix.length-1];

		while (l < r) {
			int m = l + (r-l)/2;
			int n = findPosition(matrix, m);
			if ( n < k ) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		return l;
	}

	private int findPosition(int[][] matrix, int target) {
		int count = 0;
		int i = 0;
		int j = matrix.length-1;

		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] <= target) {
				i++;
				count += j+1;
			} else {
				j--;
			}
		}
		return count;
	}
		
}
