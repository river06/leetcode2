class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int[] arr = nums;
		if(nums == null || nums.length == 0) return false;
		if(k <= 0) return false;
		if(k == 1) return true;
		int sum = 0;
		for(int i : nums){
			sum += i;
		}
		if(sum % k != 0) return false;
		int n = nums.length;
		boolean[][] dp = new boolean[sum + 1][n + 1];
		Arrays.fill(dp[0], true);
		for(int i = 1; i <= sum; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = dp[i][j - 1];
				if(i >= arr[j - 1])
					dp[i][j] |= dp[i - arr[j - 1]][j - 1];
			}
		}
		int sub = sum / k;
		for(int i = 0; i <= sum; i += sub){
			if(dp[i][n] == false) return false;
		}
		return true;
	}
}
