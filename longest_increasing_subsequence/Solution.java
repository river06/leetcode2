class Solution {
    public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) { return 0; }
		// dynamic programming
		int length = 0;
		// stores max length if use nums[i]
		int[] dp = new int[nums.length]; 
		for (int i=0; i<nums.length; i++) {
			int subLength = 0;
			for (int j=0; j<=i; j++) {
				if (nums[j] < nums[i] || i==j) {
					subLength = Math.max(subLength, dp[j]+1);
				}
			}
			dp[i] = subLength;
			length = Math.max(length, subLength);
		}
		return length;
    }
}
