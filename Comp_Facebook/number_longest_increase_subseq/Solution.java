import java.util.*;
class Solution {
    public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
        // DP
		int[] length = new int[nums.length];
		int[] count = new int[nums.length];
		int maxLength = 1;

		length[0] = 1;
		count[0] = 1;

		for (int i=1; i<nums.length; i++) {
			int tmpLength = 0;
			for (int j=0; j<i; j++) {
				if (nums[j] < nums[i]) {
					tmpLength = Math.max(tmpLength, length[j]);
				}
			}
			int tmpCount = 0;
			for (int j=0; j<i; j++) {
				if (nums[j] < nums[i] && length[j] == tmpLength) {
					tmpCount += count[j];
				}
			}

			length[i] = tmpLength + 1;
			count[i] = tmpCount > 0 ? tmpCount : 1;

			maxLength = Math.max(maxLength, length[i]);
		}
		int ret = 0;
		for (int i=0; i<nums.length; i++) {
			if (length[i] == maxLength) {
				ret += count[i];
			}
		}
		return ret;
    }
}
