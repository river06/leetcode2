class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
		int l = A[0].length;
		int n = B[0].length;
		int[][] C = new int[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<l; j++) {
				if (A[i][j] != 0) {
					for (int k=0; k<n; k++) {
						C[i][k] += A[i][j] * B[j][k];
					}
				}
			}
		}

		return C;
    }
}
