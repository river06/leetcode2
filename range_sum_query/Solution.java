class NumArray {
	int[] sum;
    public NumArray(int[] nums) {
        this.sum = new int[nums.length+1];
		for (int i=0; i<nums.length; i++) {
			this.sum[i+1] = this.sum[i] + nums[i];
		}
    }
    
    public int sumRange(int i, int j) {
        return this.sum[j+1] - this.sum[i];
    }
}
