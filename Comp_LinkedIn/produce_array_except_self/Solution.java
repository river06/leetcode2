class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lRet = new int[nums.length];
		int[] rRet = new int[nums.length];
		lRet[0] = 1;
		rRet[nums.length-1] = 1;
		for (int i=1; i<nums.length; i++) {
			lRet[i] = lRet[i-1] * nums[i-1];
			rRet[nums.length-1-i] = rRet[nums.length-i] * nums[nums.length-i];
		}
		int[] ret = new int[nums.length];
		for (int i=0; i<nums.length; i++) {
			ret[i] = lRet[i] * rRet[i];
		}
		return ret;
    }
}
