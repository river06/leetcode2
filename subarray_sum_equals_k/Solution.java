import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ret = 0;
		if (nums == null || nums.length == 0) { return ret; }

		Map<Integer, Integer> sum2Occ = new HashMap<Integer, Integer>();
		sum2Occ.put(0, 1);
		int sum = 0;

		for (int num: nums) {
			sum += num;
			ret += sum2Occ.getOrDefault(sum - k, 0);
			sum2Occ.put(sum, sum2Occ.getOrDefault(sum, 0) + 1);
		}

		return ret;
    }
}
