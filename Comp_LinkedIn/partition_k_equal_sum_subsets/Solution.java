import java.util.*;
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
		if (nums == null || nums.length == 0) { return false; }
		int sum = 0;
		Integer[] newNums = new Integer[nums.length];
		for (int i=0; i<nums.length; i++) {
			sum += nums[i];
			newNums[i] = nums[i];
		}
		if (sum % k != 0) { return false; }
		int subSum = sum / k;
		boolean[] isUsed = new boolean[nums.length];
		Arrays.sort(newNums, Collections.reverseOrder());
		while (k > 0) {
			boolean isGood = backTracking(newNums, isUsed, subSum);
			if (!isGood) { return false; }
			k--;
		}
		return true;
    }

	private boolean backTracking(Integer[] nums, boolean[] isUsed, int left) {
		if (left == 0) { return true; }
		if (left < 0) { return false; }
		for (int i=0; i<nums.length; i++) {
			if (!isUsed[i] && nums[i] <= left) {
				isUsed[i] = true;
				boolean isGood = backTracking(nums, isUsed, left - nums[i]);
				if (isGood) { return true; }
				isUsed[i] = false;
			}
		}
		return false;
	}
}
