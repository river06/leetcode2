class Solution {
    public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, nums.length-k);
    }

	private int quickSelect(int[] nums, int k) {
		int l = 0;
		int r = nums.length-1;

		while (true) {
			int m = partition(nums, l, r);
			if (m == k) {
				return nums[m];
			} else if (m > k) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
	}

	private int partition(int[] nums, int l, int r) {
		int s = l;
		int e = r-1;
		while (s <= e) {
			if (nums[s] > nums[r]) {
				swap(nums, s, e);
				e--;
			} else {
				s++;
			}
		}

		swap(nums, s, r);

		return s;
	}

	private void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
}
