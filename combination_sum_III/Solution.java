import java.util.*;
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		List<Integer> cand = new LinkedList<Integer>();
		dfs(ret, cand, 1, k, n);
		return ret;
    }

	void dfs(List<List<Integer>> ret, List<Integer>cand, int next_int, int k, int n) {
		// shortcut
		if(k==1){
			if( next_int <= n && n <= 9){
				cand.add(n);
				List<Integer> cand_ret = new LinkedList<Integer>(cand); 
				ret.add(cand_ret);
				cand.remove(cand.size()-1);
			}
			return;
		}

		for(int i = next_int; i<=9; i++){
			cand.add(i);
			dfs(ret, cand, i+1, k-1, n-i);
			cand.remove(cand.size()-1);
		}
				  
	}
}
