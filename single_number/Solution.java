public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
		if( nums.length==0 ){ return ret; }

		for(int i=0; i<nums.length; i++) {
			ret ^= nums[i];
		}
		return ret;
    }
}
