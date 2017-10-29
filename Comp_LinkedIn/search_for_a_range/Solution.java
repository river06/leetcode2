class Solution {
    public int[] searchRange(int[] nums, int target) {
		int[] ret = {-1, -1};
        if (nums == null || nums.length == 0) {
			return ret;
		}

		// search for start
		int l = 0;
		int r = nums.length-1;

		while (l + 1 < r) {
			int m = l + (r-l)/2;

			if (nums[m] == target) {
				r = m;
			} else if (nums[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		if (nums[l] == target) {
			ret[0] = l;
		} else if (nums[r] == target) {
			ret[0] = r;
		}

		if (ret[0] == -1) { return ret; }

		// search for end
		l = 0;
		r = nums.length - 1;

		while (l + 1 < r) {
			int m = l + (r-l)/2;

			if (nums[m] == target) {
				l = m;
			} else if (nums[m] > target) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		if (nums[r] == target) {
			ret[1] = r;
		} else if (nums[l] == target) {
			ret[1] = l;
		}

		return ret;
    }
}
