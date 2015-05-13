import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if( candidates == null || candidates.length == 0) return ret;

		Arrays.sort(candidates);

		// maybe only need backtracking?

		List<Integer>com = new LinkedList<Integer>();
		boolean[] candi_used = new boolean[candidates.length];
		Arrays.fill(candi_used, false);
			
		helper(ret, com, candidates, target, 0, candi_used);
		
		return ret;
    }

    private void helper(List<List<Integer>>ret, List<Integer> com, int[] candidates, int target, int n_can, boolean[] candi_used)  {
		// base case
		if(target <0) return;
		if(target == 0) {
			List<Integer> com_ret = new LinkedList<Integer> (com);
			ret.add( com_ret );
			return;
		}

		for( int i=n_can; i<candidates.length; i++) {
			if( target - candidates[i] <0) break; // cut uncessary branches

			// skip duplicate numbers
			if(i>0 && candidates[i]==candidates[i-1] && candi_used[i-1]==false) continue;

			candi_used[i]= true;
			com.add( candidates[i] );
			helper(ret, com, candidates, target - candidates[i], i+1, candi_used);
			// each number can only be used once
			com.remove( com.size()-1);
			candi_used[i] =  false;
		}
		
   }		
		
}
