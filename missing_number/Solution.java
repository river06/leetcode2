public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length==0) return 0;
		int ret = 0;

		for( int i=0; i<nums.length; i++) {
			ret^=i;
			ret^=nums[i];
		}
		return (ret^nums.length);
    }
}
