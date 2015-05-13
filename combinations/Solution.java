import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new LinkedList<List<Integer>>();
		if(n<k || n<0 || k<0) return ret;

		List<Integer> cur = new LinkedList<Integer>();
		helper(ret, cur, n, k, 1);
		return ret;
		
    }

	private void helper(List<List<Integer>> ret, List<Integer> cur, int n, int k, int ii) {
		// base case
		if(k == 0) {
			List<Integer> cur_copy = new LinkedList<Integer>(cur);
			ret.add(cur_copy);
			return;
		}

		// accelerate
		if(ii + k -1> n) return;

		for(int i=ii; i<=n; i++) {
			cur.add(i);
			helper(ret, cur, n, k-1, i+1);
			cur.remove( cur.size()-1);
		}
	}
}
