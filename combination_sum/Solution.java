import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if( candidates == null || candidates.length == 0) return ret;

		Arrays.sort(candidates);

		// maybe only need backtracking?

		List<Integer>com = new LinkedList<Integer>();
		helper(ret, com, candidates, target, 0);

		
		return ret;
    }

    private void helper(List<List<Integer>>ret, List<Integer> com, int[] candidates, int target, int n_can)  {
		// base case
		if(target <0) return;
		if(target == 0) {
			List<Integer> com_ret = new LinkedList<Integer> (com);
			ret.add( com_ret );
			return;
		}

		for( int i=n_can; i<candidates.length; i++) {
			if( target - candidates[i] <0) break; // cut uncessary branches
			
			com.add( candidates[i] );
			helper(ret, com, candidates, target - candidates[i], i);
			com.remove( com.size()-1);
		}
		
   }		
		
}
