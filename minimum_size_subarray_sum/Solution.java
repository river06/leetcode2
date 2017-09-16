class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // Two pointers algorithm !!!

		if (nums == null || nums.length == 0) { return 0; }

		int pl = 0;
		int pr = 0;
		int sum = nums[0];
		int length = 0;
		while (pl <= pr) {
			if (sum >= s) {
				int curLength = pr - pl + 1;
				length = length == 0 ? curLength : Math.min(length, curLength);
				sum -= nums[pl];
				pl ++;
			} else {
				pr ++;
				if (pr >= nums.length) { break; }
				sum += nums[pr];
			}
		}

		return length;
	}
}
