class Solution {
    public int maxCoins(int[] nums) {
        // process boundary and zero coin ballons
		int[] coins = new int[nums.length+2];
		coins[0] = 1;
		int n = 1;
		for (int num: nums) {
			if (num > 0) {
				coins[n++] = num;
			}
		}
		coins[n++] = 1;

		int[][] dp = new int[n][n]; // dp[i][j] denotes max coin by balloon (i, j)
		for (int k=2; k<n; k++) {
			for (int l = 0; l + k < n; l++) {
				int r = l + k;
				for (int m = l+1; m < r; m++) {
					dp[l][r] = Math.max(dp[l][r],
										dp[l][m] + coins[l]*coins[m]*coins[r] +
										dp[m][r]);
				}
			}
		}
		return dp[0][n-1];
    }
}
