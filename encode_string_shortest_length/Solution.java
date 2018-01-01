class Solution {
	/**
	 * divide and conquer style DP solution
	 */
    public String encode(String s) {
		int n = s.length();
		// dp(i,j) stores the encoded string from position i to j
		String[][] dp = new String[n][n];

		for (int l=1; l<=n; l++) {
			for (int i=0; i<=n-l; i++) {
				int j = i+l-1;
				String subStr = s.substring(i, j+1);
				dp[i][j] = subStr;

				if (l >= 5) {
					// first find if any combination of encoded string is shorter
					for (int k=i; k<j; k++) {
						if (dp[i][k].length() + dp[k+1][j].length() <
							dp[i][j].length()) {
							dp[i][j] = dp[i][k] + dp[k+1][j];
						}
					}

					// encode the entire string itself;
					for (int k = subStr.length()-2; k>=0; k--) {
						String repeatStr = subStr.substring(0, k+1);
						if (repeatStr != null &&
							subStr.length() % (k+1) == 0 &&
							subStr.replaceAll(repeatStr, "").length() == 0) {
							String ss = subStr.length() / (k+1) + "[" +
								dp[i][i+k] + "]";
							if (ss.length() <= dp[i][j].length()) {
								dp[i][j] = ss;
							}
						}
					}
				}

			}
		}
		return dp[0][s.length()-1];
    }
}
