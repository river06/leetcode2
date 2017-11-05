class Solution {
    public int maxProduct(int[] nums) {
		int maxVal = nums[0];
		int minVal = nums[0];
		int ret = nums[0];
		
		for (int i=1; i<nums.length; i++) {
			if (nums[i] >= 0) {
				maxVal = Math.max(nums[i], maxVal * nums[i]);
				minVal = Math.min(nums[i], minVal * nums[i]);
			} else {
				int preMax = maxVal;
				maxVal = Math.max(nums[i], minVal * nums[i]);
				minVal = Math.min(nums[i], preMax * nums[i]);
			}

			ret = Math.max(ret, maxVal);
		}

		return ret;
    }
}
