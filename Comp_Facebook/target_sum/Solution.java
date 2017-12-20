class Solution {
    public int findTargetSumWays(int[] nums, int S) {
		int offset = 1000;
		int[][] dp = new int[nums.length][2001];

		dp[0][nums[0] + offset] = 1;
		dp[0][-nums[0] + offset] += 1;
		for (int i=1; i<nums.length; i++) {
			for (int sum = -1000 + offset; sum <= 1000 + offset; sum++) {
				if (dp[i-1][sum] > 0) {
					dp[i][sum + nums[i]] += dp[i-1][sum];
					dp[i][sum - nums[i]] += dp[i-1][sum];
				}
			}
		}

		return S > 1000 ? 0 : dp[nums.length - 1][S + offset];
    }
}
