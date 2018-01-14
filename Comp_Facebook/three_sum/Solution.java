import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return ret;
		}

		Arrays.sort(nums);
		int i=0;
		while (i < nums.length) {
			int target = -nums[i];

			int l = i+1;
			int r = nums.length-1;

			while (l < r) {
				int sum = nums[l] + nums[r];
				if (sum == target) {
					ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}

				if (l > i+1) {
					while (l <nums.length && nums[l-1] == nums[l]) { l++; }
				}
				if (r < nums.length-1) {
					while (r>=0 && nums[r+1] == nums[r]) { r--; }
				}
			}
			i++;
			while (i < nums.length && nums[i] == nums[i-1]) { i++; }
		}
		return ret;
    }
}
