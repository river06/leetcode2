import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num2Idx = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        for (int i=0; i<nums.length; i++) {
			
			if (num2Idx.containsKey(target - nums[i])) {
				ret[0] = num2Idx.get(target-nums[i]);
                ret[1] = i;
                break;
            }

            if (!num2Idx.containsKey(nums[i])) {
                num2Idx.put(nums[i], i);
            }
        }
        return ret;
    }
}
