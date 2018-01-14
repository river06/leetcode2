import java.util.*;
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		// 2D DP approach
		int n = 3; // number of sums in question
		
		// get the sums of sub-array with length k
		int[] sums = getSums(nums, k);

		System.out.println(Arrays.toString(sums));
			
		// dp[i][j] represents the maximum of sum of ith sub-array in the first j sums
		int[][] dp = new int[n+1][sums.length+1];
		// id[i][j] represents the start index of ith sub-array resulting in the max
		// sum in the first j sums
		int[][] id = new int[n+1][sums.length+1];

		// initialize dp for the first sum
		int maxSum = 0;
		for (int j=0; j<sums.length; j++) {
			dp[1][j+1] = Math.max(maxSum, sums[j]);
			id[1][j+1] = sums[j] > maxSum ? j : id[1][j];
			maxSum = dp[1][j+1];
		}

		//System.out.println(Arrays.toString(dp[1]));
		//System.out.println(Arrays.toString(id[1]));
		
		for (int i=2; i<=n; i++) {
			for (int j=(i-1)*k; j < sums.length; j++) {
				int dp1 = dp[i][j+1-1];
				int dp2 = j-k >=0 ? dp[i-1][j-k+1] + sums[j] : Integer.MIN_VALUE;
				dp[i][j+1] = Math.max(dp1, dp2);

				id[i][j+1] = dp2 > dp1 ? j : id[i][j];
			}

			System.out.println(Arrays.toString(id[i]));
		}

		int[] ret = new int[3];
		ret[2] = id[n][sums.length];
		ret[1] = id[n-1][ret[2]-k+1];
		ret[0] = id[n-2][ret[1]-k+1];
		return ret;
    }

	private int[] getSums(int[] nums, int k) {
		int[] sums = new int[nums.length - k + 1];
		// initial sum
		for (int i=0; i<k; i++) {
			sums[0] += nums[i];
		}

		// remaining sums
		int p = 0;
		for (int i=1; i<sums.length; i++) {
			sums[i] = sums[i-1] - nums[p];
			sums[i] += nums[p+k];
			p++;
		}

		return sums;
	}
}
