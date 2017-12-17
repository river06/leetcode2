class Solution {
    public void moveZeroes(int[] nums) {
        int p0 = -1;
		for (int i=0; i<nums.length; i++) {
			if (nums[i] == 0) {
				if (p0 == -1) { p0 = i; }
			} else if (p0 != -1) {
				nums[p0] = nums[i];
				nums[i] = 0;
				p0++;
			}
		}
    }
}
