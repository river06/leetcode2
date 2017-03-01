public class Solution {
    public int maxSubArray(int[] nums) {
        if( nums==null || nums.length<=0 ) { return 0; }
		int ret = Integer.MIN_VALUE;
		int positive = Integer.MIN_VALUE; // contiguous positive value
		for( int num: nums ) {
			if( positive <0 ) {
				positive = num;
			} else {
				positive = positive+num;
			}
			ret = Math.max(ret, positive);
		}
		return ret;
    }
}
