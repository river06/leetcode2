import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
		if (nums.length == 1) { return nums[0]; }

		int[] ret = helper(nums, 0, nums.length-1);
		return ret[0];
    }

	private int[] helper(int[] nums, int l, int r) {
		// max over all, sum, max from left, max from right
		int[] ret = new int[4];
		if (l == r) {
		   Arrays.fill(ret, nums[l]);
		   return ret;
		}
		int m = l + (r-l)/2;
		int[] lRet = helper(nums, l, m);
		int[] rRet = helper(nums, m+1, r);

		ret[0] = Math.max(lRet[3] + rRet[2], Math.max(lRet[0], rRet[0]));
		ret[1] = lRet[1] + rRet[1];
		ret[2] = Math.max(lRet[2], lRet[1] + rRet[2]);
		ret[3] = Math.max(rRet[3], rRet[1] + lRet[3]);
		return ret;
	}
}
