class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
		int minLength = 0;
		int l = 0;
		int r = 0;

		while (r < nums.length) {
			sum += nums[r];

			while (sum >= s) {
				if (minLength == 0 || r-l+1 < minLength) {
					minLength = r-l+1;
				}

				sum -= nums[l];
				l++;
			}
			r++;
		}

		return minLength;
    }
}
