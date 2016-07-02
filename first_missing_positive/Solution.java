public class Solution {
    public int firstMissingPositive(int[] nums) {
        // bucket sort
		int n = nums.length;
		int i = 0;
		while(i<n) {
			if( nums[i] > 0 && nums[i] <=n &&
				nums[i]!=i+1 && nums[nums[i]-1] != nums[i]) {
				// swap
				int tmp = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = tmp;
			} else {
				i++;
			}
		}
		for(i=0; i<n; i++) {
			if(nums[i] != i+1) return i+1;
		}
		return n+1;
    }
}
