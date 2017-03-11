import java.util.*;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> cur = new ArrayList<Integer>();
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if(nums==null || nums.length==0) { return ret; }
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(ret, cur, nums, 0, used);
		return ret;
    }

	void helper(List<List<Integer>> ret, List<Integer> cur, int[] nums,
				int idx, boolean[] used) {
		// base case
		if( idx >= nums.length ) {
			ret.add( new ArrayList<Integer>(cur) );
			return;
		}
		
		if(idx>0 && nums[idx]==nums[idx-1] && !used[idx-1]) {
			helper(ret, cur, nums, idx+1, used);
		} else {

			cur.add( nums[idx] );
			used[idx] = true;
			helper(ret, cur, nums, idx+1, used);
			
			cur.remove( cur.size()-1 );
			used[idx] = false;
			helper(ret, cur, nums, idx+1, used);
		}
	}
}
