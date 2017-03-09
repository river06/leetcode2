import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		//if( nums==null || nums.length==0 ) { return ret; }

		List<Integer> curRet = new ArrayList<Integer>();
		helper(nums, 0, curRet, ret);

		return ret;
    }

	private void helper(int[] nums, int idx, List<Integer> curRet, List<List<Integer>> ret ) {
		if( idx == nums.length ) {
			ret.add( new ArrayList<Integer>( curRet ) );
			return;
		}

		curRet.add(nums[idx]);
		helper(nums, idx+1, curRet, ret);
		curRet.remove(curRet.size()-1);
		helper(nums, idx+1, curRet, ret);

	}
}
