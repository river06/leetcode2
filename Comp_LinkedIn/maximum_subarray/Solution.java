class Solution {
    public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int ret = nums[0];
		int cont = nums[0];
		for (int i=1; i<nums.length; i++) {
			cont = Math.max(cont + nums[i], nums[i]);
			ret = Math.max(ret, cont);
		}

		return ret;
    }
}
