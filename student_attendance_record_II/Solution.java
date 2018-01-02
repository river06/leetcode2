class Solution {
    public int checkRecord(int n) {
		int MOD = 1000000007;
		// initialize it
		// A, L, AL, LL, ALL, P, AP
        int[] dp = {1, 1, 0, 0, 0, 1, 0};
		for (int i=1; i<n; i++) {
			int[] newDp = new int[7];
			newDp[0] = ((dp[1] + dp[3])%MOD + dp[5])%MOD;
			newDp[1] = dp[5];
			newDp[2] = (dp[0] + dp[6])%MOD;
			newDp[3] = dp[1];
			newDp[4] = dp[2];
			newDp[5] = ((dp[1] + dp[3])%MOD + dp[5])%MOD;
			newDp[6] = (((dp[0] + dp[2])%MOD + dp[4])%MOD + dp[6])%MOD;

			dp = newDp;
		}
		int ret = 0;
		for (int num: dp) {
			ret += num;
			ret %= MOD;
		}
		return ret;
    }
}
