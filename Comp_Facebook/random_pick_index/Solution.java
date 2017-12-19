import java.util.*;
class Solution {

	private int[] nums;
	private Random rdm;
	
    public Solution(int[] nums) {
		this.nums = nums;
		this.rdm = new Random();
    }
    
    public int pick(int target) {
        int ret = 0;
		int count = 1;
		for (int i=0; i<this.nums.length; i++) {
			if (nums[i] == target && rdm.nextInt(count++) == 0) {
				ret = i;
			}
		}
		return ret;
    }
}
