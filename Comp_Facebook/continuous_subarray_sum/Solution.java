import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
		
        Map<Integer, Integer> sum2Idx = new HashMap<Integer, Integer>();
		
		int sum = 0;
		for (int i=0; i<nums.length; i++) {
			sum += nums[i];

			if (((k != 0 && sum % k == 0) || (k == 0 && sum == 0)) && i>=1) {
				return true;
			} else {
				
				int mod = k != 0 ? sum % k : sum;
				
				if (sum2Idx.containsKey(mod) && i - sum2Idx.get(mod) >= 2) {
					return true;
				}

				if (!sum2Idx.containsKey(mod)) {
					sum2Idx.put(mod, i);
				}
			}
		}

		return false;
    }
}
