class Solution {
    public int countCornerRectangles(int[][] grid) {
		if (grid == null) { return 0; }
        int m = grid.length;
		int n = grid[0].length;
		if (m <= 1 || n <= 1) { return 0; }
		int ret = 0;
		// one direction
		boolean iterateOverRow = m > n ? false : true;
		int length = iterateOverRow ? m : n;
		for (int i=0; i<length; i++) {
			for (int j=i+1; j<length; j++) {
				int[] sum = getSum(grid, i, j, iterateOverRow);
				ret += getNRectangle(sum);
			}
		}
		return ret;
    }

	private int getNRectangle(int[] sum) {
		int n2 = 0;
		for (int num: sum) {
			if (num >= 2) { n2++; }
		}
		return n2 * (n2-1) / 2;
	}
	private int[] getSum(int[][] grid, int i, int j, boolean iterateOverRow) {
		int[] ret = new int[iterateOverRow ? grid[0].length : grid.length];
		for (int k = 0; k<ret.length; k++) {
			int num1 = iterateOverRow ? grid[i][k] : grid[k][i];
			int num2 = iterateOverRow ? grid[j][k] : grid[k][j];
			ret[k] = num1 + num2;
		}
		return ret;
	}
}
