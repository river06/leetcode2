import java.util.*;
class Solution {
	List<String> ret;
    public List<String> removeInvalidParentheses(String s) {
        ret = new ArrayList<String>();

		dfs(new StringBuilder(s), 0, 0, new char[] {'(', ')'});
		
		return ret;
    }

	private void dfs(StringBuilder sb, int start, int removeStart, char[] pars) {
		int nOpen = 0;
		for (int r=start; r < sb.length(); r++) {
			if (sb.charAt(r) == pars[0]) { nOpen++; }
			if (sb.charAt(r) == pars[1]) { nOpen--; }

			if (nOpen < 0) {
				for (int i=removeStart; i<=r; i++) {
					if (sb.charAt(i) == pars[1] &&
						(i == removeStart || sb.charAt(i-1) != pars[1])) {
						StringBuilder nb = new StringBuilder(sb);
						nb.deleteCharAt(i);
						dfs(nb, r, i, pars);
					}
				}
				return;
			}
		}

		// reverse and remove extra open parentheses
		sb.reverse();
		
		if (pars[0] == '(') {
			dfs(sb, 0, 0, new char[] {')', '('});
		} else {
			ret.add(sb.toString());
		}
	}
}
