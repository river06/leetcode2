class Solution {
    public int findKthLargest(int[] nums, int k) {
        // quick select
		int ret = quickSelect(nums, k-1, 0, nums.length-1);
		return ret;
    }

	private int quickSelect(int[] nums, int k, int start, int end) {
		int pivot = nums[end];

		int l = start;
		int r = end - 1;

		while (l <= r) {
			if (nums[l] >= pivot) {
				l++;
			} else {
				swap(nums, l, r);
				r--;
			}
		}
		swap(nums, l, end);
		if (l == k) {
			return nums[l];
		} else if (l < k) {
			return quickSelect(nums, k, l + 1, end);
		} else {
			return quickSelect(nums, k, start, l - 1);
		}
	}

	private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
}
