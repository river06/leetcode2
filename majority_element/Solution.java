/**
 * Moore's algorithm
 */
public class Solution {
    public int majorityElement(int[] nums) {
		int idx = 0;
		int count = 1;

		for (int i=1; i<nums.length; i++) {
			if (nums[idx]==nums[i]) {
				count++;
			} else {
				count--;
			}
			if (count==0) {
				idx = i;
				count = 1;
			}
		}

		return nums[idx];
    }
}
