import java.util.*;
class Solution {
	private Map<Integer, Integer> target2Com = new HashMap<Integer, Integer>();
	
    public int combinationSum4(int[] nums, int target) {
        // backtracking algorithm
		if (target == 0) { return 1; }
		if (target < 0) { return 0; }
		if (target2Com.containsKey(target)) {
			return target2Com.get(target);
		}
		int ret = 0;
		for (int i=0; i<nums.length; i++) {
			int subRet = combinationSum4(nums, target - nums[i]);
			if (!target2Com.containsKey(target-nums[i])) {
				target2Com.put(target-nums[i], subRet);
			}
			ret += subRet;
		}
		return ret;
    }
}
