import java.util.*;
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
		List<Integer> cur = new LinkedList<Integer>();
		backTracking(ret, cur, 2, n);
		return ret;
    }

	private void backTracking(List<List<Integer>> ret, List<Integer> cur, Integer last,
							  Integer left) {
		// base case
		if (cur.size() > 0) {
			List<Integer> newRet = new LinkedList<Integer>(cur);
			newRet.add(left);
			ret.add(newRet);
		}

		for (int num1 = last; num1 <= left/num1; num1++) {
			if (left % num1 == 0) {
				cur.add(num1);
				backTracking(ret, cur, num1, left / num1);
				cur.remove(cur.size()-1);
			}
		}
	}
}
