import java.util.*;
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
        if (nums == null || nums.length < 3) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i<nums.length-2; i++) {
			int j = i+1;
			int k = nums.length-1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] < target) {
					ret += k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return ret;
    }
}
