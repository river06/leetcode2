import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) { return ret; }

		boolean[] isUsed = new boolean[nums.length];
		List<Integer> cur = new ArrayList<Integer>(nums.length);
		helper(nums, isUsed, ret, cur, nums.length);

		return ret;
    }

	private void helper(int[] nums, boolean[] isUsed, List<List<Integer>> ret,
						List<Integer> cur, int nLeft) {
		if (nLeft == 0) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i=0; i<nums.length; i++) {
			if (isUsed[i] == false) {
				isUsed[i] = true;
				
				if (cur.size() < nums.length) {
					cur.add(nums[i]);
				} else {
					cur.set(nums.length-nLeft, nums[i]);
				}

				helper(nums, isUsed, ret, cur, nLeft-1);

				isUsed[i] = false;
			}
		}
	}
}
