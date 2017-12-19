import java.util.*;
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLength = 0;

		Map<Integer, Integer> sum2Idx = new HashMap<Integer, Integer>();
		
		int sum = 0;
		
		for (int i = 0; i<nums.length; i++) {
			sum += nums[i];

			if (sum == k) {
				maxLength = i + 1;
			} else if (sum2Idx.containsKey(sum-k)) {
				maxLength = Math.max(maxLength, i - sum2Idx.get(sum-k));
			}

			if (!sum2Idx.containsKey(sum)) {
				sum2Idx.put(sum, i);
			}
		}

		return maxLength;
    }
}
