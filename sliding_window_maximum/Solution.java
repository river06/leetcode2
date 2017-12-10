import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge cases
		if (nums == null || nums.length == 0 || k <= 0) {
			return new int[0];
		}

		int[] ret = new int[nums.length - k + 1];

		Deque<Integer> deque = new ArrayDeque<Integer>();

		for (int i=0; i<nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i-k) {
				deque.pollFirst();
			}

			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}

			deque.offerLast(i);

			if (i >= k-1) {
				ret[i-(k-1)] = nums[deque.peekFirst()];
			}
		}

		return ret;
    }
}
