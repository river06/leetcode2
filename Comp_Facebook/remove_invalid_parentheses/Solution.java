import java.util.*;
class Solution {
    public List<String> removeInvalidParentheses(String s) {
       List<String> ret = new ArrayList<String>();
	   dfs(ret, s, 0, 0, new char[] {'(', ')'});
	   return ret;
    }

	/**
	 * depth first search algorithm
	 */
	private void dfs(List<String> ret, String s, int lastEnd,
		int removeStart, char[] par) {
		int counter = 0;
		for (int i=lastEnd; i<s.length(); i++) {
			if (s.charAt(i) == par[0]) { counter++; }
			if (s.charAt(i) == par[1]) { counter--; }
			if (counter < 0) {
				// we need to move one right parenthesis
				// we also can not continue to get the reverse string
				for (int r=removeStart; r<=i; r++) {
					if (s.charAt(r) == par[1] &&
						(r==removeStart || s.charAt(r-1) != par[1])) {
						dfs(ret, s.substring(0, r) + s.substring(r+1),
							i, r, par);
					}
				}
				return;
			}
		}

		String reversed = new StringBuilder(s).reverse().toString();

		if (par[0] == '(') {
			dfs(ret, reversed, 0, 0, new char[] {')', '('});
		} else {
			ret.add(reversed);
		}
	}
}
