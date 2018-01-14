import java.util.*;
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = 3;
		int[] sums = getSums(nums, k);

		System.out.println(Arrays.toString(sums));
		
        int[][] dp = new int[sums.length+k][n+1];
		int[][] id = new int[sums.length+k][n+1];
		
		// initialize the dp array
		for (int i=0; i<k; i++) {
			for (int j=1; j<n+1; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}

		for (int i=0; i<sums.length; i++) {
			for (int j=1; j<=n; j++) {
				int tmp1 = dp[i-k+k][j-1] + sums[i];

				int tmp2 = dp[i-1+k][j];

				dp[i+k][j] = Math.max(tmp1, tmp2);

				if (tmp1 > tmp2) {
					id[i+k][j] = i;
				} else {
					id[i+k][j] = id[i-1+k][j];
				}
			}
		}

		for (int i=0; i<dp.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}

		for (int i=0; i<id.length; i++) {
			System.out.println(Arrays.toString(id[i]));
		}

		int[] res = new int[3];
        res[2] = id[sums.length + k - 1][3];
        res[1] = id[res[2]][2];
        res[0] = id[res[1]][1];        
        return res;
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
