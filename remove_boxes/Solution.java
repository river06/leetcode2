class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
		int[][][] dp = new int[n][n][n];

		for (int j=0; j<n; j++) {
			for (int k =0; k<=j; k++) {
				dp[j][j][k] = (k+1)*(k+1);
			}
		}

		for (int l = 1; l < n; l++) {
			for (int j=1; j<n; j++) {
				int i = j-l;

				for (int k=0; k<=i; k++) {
					int ret = (k+1)*(k+1) + dp[i+1][j][0];
					for (int m = i+1; m<=j; m++) {
						if (boxes[m] == boxes[i]) {
							ret = Math.max(ret, dp[i+1][m-1][0] +
										   dp[m][j][k+1]);
						}
					}

					dp[i][j][k] = ret;
				}
			}
		}

		return n == 0 ? 0 : dp[0][n-1][0];
    }
}
