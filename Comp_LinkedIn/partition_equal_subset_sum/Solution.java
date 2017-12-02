class Solution {
    public boolean canPartition(int[] nums) {
        // knapsack problem. DP algorithm.
		if (nums == null || nums.length < 2) { return false; }

		// dp[i][j] represents if seb set of first i nums can sum to j
		int sum = Arrays.stream(nums).sum();

		if ( (sum&1) != 0 ) { return false; }

		int target = sum >> 1;

		boolean[][] dp = new boolean[nums.length+1][target+1];

		for (int i=0; i<=nums.length; i++) {
			dp[i][0] = true;
		}

		for (int i=1; i <= nums.length; i++) {
			for (int j=1; j <= target; j++) {
				dp[i][j] = dp[i-1][j];
				if (j >= nums[i-1]) {
					dp[i][j] |= dp[i-1][j - nums[i-1]];
				}
			}
		}
		return dp[nums.length][target];
    }
}
