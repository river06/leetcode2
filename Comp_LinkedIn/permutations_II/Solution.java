import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if (nums == null || nums.length == 0) { return ret; }

		List<Integer> cur = new ArrayList<Integer>(nums.length);
		boolean[] isUsed = new boolean[nums.length];
		Arrays.sort(nums);
		
		backtrack(ret, cur, nums, isUsed, nums.length);

		return ret;
    }

	private void backtrack(List<List<Integer>> ret, List<Integer> cur,
						   int[] nums, boolean[] isUsed, int nLeft) {
		if (nLeft == 0) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}

		for (int i=0; i<nums.length; i++) {
			if (isUsed[i] == false) {
				if (i>0 && nums[i-1] == nums[i] && isUsed[i-1] == false) {
					continue;
				}

				if (cur.size() < nums.length) {
					cur.add(nums[i]);
				} else {
					cur.set(nums.length-nLeft, nums[i]);
				}

				isUsed[i] = true;

				backtrack(ret, cur, nums, isUsed, nLeft-1);

				isUsed[i] = false;
			}
		}
	}
}
