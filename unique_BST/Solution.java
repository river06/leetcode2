class Solution {
    public int numTrees(int n) {
		if (n<=1) { return n; }
        int[] nums = new int[n+1];

		nums[0] = 1;

		for (int i=1; i<=n; i++) {
			for (int j=0; j<i; j++) {
				nums[i] += nums[j]*nums[i-j-1];
			}
		}
		return nums[n];
    }
}
