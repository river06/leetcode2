import java.util.*;
class Solution {
    public int findMaxLength(int[] nums) {
        int ret = 0;
		Map<Integer, Integer> count2Idx = new HashMap<Integer, Integer>();
		count2Idx.put(0, -1);
		
		int count = 0;
		for (int i=0; i<nums.length; i++) {
			int num = nums[i];
			if (num == 1) {
				count++;
			} else {
				count--;
			}
			if (count2Idx.containsKey(count)) {
				ret = Math.max(ret, i - count2Idx.get(count));
			} else {
				count2Idx.put(count, i);
			}
		}

		return ret;
    }
}
