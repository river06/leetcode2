class Solution {
    public int search(int[] nums, int target) {
		int ret = -1;
        if (nums == null || nums.length == 0) {
			return ret;
		}

		int l = 0, r = nums.length-1;
		while (l + 1 < r) {
			int m = l + (r-l)/2;
			if (nums[m] == target) {
				ret = m;
				break;
			} else if (nums[l] > nums[m]) {
				if (nums[m] < target && target <= nums[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			} else {
				if (nums[l] <= target && target < nums[m]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
		}

		if (nums[l] == target) { ret = l; }
		if (nums[r] == target) { ret = r; }
		return ret;
    }
}
