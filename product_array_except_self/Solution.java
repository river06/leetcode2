public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] ret = new int[nums.length];
		for(int i=0; i<ret.length; i++) {
			ret[i]=1;
		}

		// left to right
		int left = 1;
		for(int i=0; i<ret.length; i++) {
			ret[i] = left;
			left *= nums[i];
		}

		int right = 1;
		for(int i=ret.length-1; i>=0; i--) {
			ret[i] *= right;
			right *= nums[i];
		}

		return ret;
	}
}
	
