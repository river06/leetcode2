class Solution {
    public int splitArray(int[] nums, int m) {
        // dynamic programming (optimization) version
		// row: number of splitted arrays. We only need two rows
		// column: end position index
		// we can start from row when m=2, but I am lazy
		int[][] dp = new int[2][nums.length];

		// initialize first row
		dp[0][0] = nums[0];
		for(int i=1; i<nums.length; i++) {
			dp[0][i] = dp[0][i-1] + nums[i];
		}
		
		// dp since second row
		for (int i=1; i<m; i++) {
			// ith row is splitted into i+1 groups :)
			int iCur = i%2;
			int iPre = 1-iCur;
			int jStart = i-1; // after this makes sense
			for (int j=i; j<nums.length; j++) {
				// optimize over previous results
				int lastSum = nums[j];
				int ret = Integer.MAX_VALUE; //dp[iPre][j]; // result is no more than this
				for (int jj=j-1; jj>=jStart; jj--) {
					int tmp = Math.max(dp[iPre][jj], lastSum);
					ret = Math.min(ret, tmp);
					lastSum += nums[jj];
				}
				dp[iCur][j] = ret;
			}
		}

		return dp[1-m%2][nums.length-1];

    }
}
