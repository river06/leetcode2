class Solution {
    public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
        int ret = 0;
		int l = 0;
		int r = 1;
		while (r < nums.length) {
			if (nums[r] > nums[r-1]) {
			} else {
				l = r;
			}
			r++;
			ret = Math.max(ret, r - l);
		}

		return ret;
    }
}
