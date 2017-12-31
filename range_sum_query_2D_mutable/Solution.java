class NumMatrix {
	int[][] tree;
	int[][] nums;
	int m;
	int n;

	NumMatrix(int[][] maxtrix) {
		if (maxtrix == null || maxtrix.length == 0 || maxtrix[0].length == 0) {
			return;
		}

		m = maxtrix.length;
		n = maxtrix[0].length;

		tree = new int[m+1][n+1];
		nums = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, maxtrix[i][j]);
			}
		}
	}

	public void update(int row, int col, int val) {
		if (m == 0 || n == 0) { return; }
		int delta = val - nums[row][col];
		nums[row][col] = val;
		for (int i = row + 1; i <= m; i += (i & (-i))) {
			for (int j = col + 1; j <= n; j += (j & (-j))) {
				tree[i][j] += delta;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (m == 0 || n == 0) { return 0; }
		return sum(row2, col2) + sum(row1-1, col1-1)
			- sum(row1-1, col2) - sum(row2, col1-1);
	}

	private int sum(int row, int col) {
		int sum = 0;
		for (int i = row+1; i>0; i -= i&(-i)) {
			for (int j=col+1; j>0; j -= j&(-j)) {
				sum += tree[i][j];
			}
		}
		return sum;
	}
}
