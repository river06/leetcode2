import java.util.*;
class Solution {
	private boolean[][] isPalindrome;
    public List<List<String>> partition(String s) {
		isPalindrome = new boolean[s.length()][s.length()];

        List<List<String>> ret = new ArrayList<List<String>>();

		// set up isPalindrome 
		for (int i=s.length()-1; i>=0; i--) {
			for (int j=i; j<s.length(); j++) {
				if (j == i) {
					isPalindrome[i][j] = true;
				} else if (j == i+1) {
					isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					isPalindrome[i][j] = isPalindrome[i+1][j-1] &&
						s.charAt(i) == s.charAt(j);
				}
			}
		}
		
		// back tracking?

		bt(s, 0, ret, new ArrayList<String>());

		return ret;
    }

	private void bt(String s, int start, List<List<String>> ret, List<String> cur) {
		// base case
		if (start >= s.length()) {
			ret.add(new ArrayList<String>(cur));
			return;
		}

		// back tracking
		for (int end=start; end<s.length(); end++) {
			if (isPalindrome[start][end]) {
				cur.add(s.substring(start, end+1));
				bt(s, end+1, ret, cur);
				cur.remove(cur.size()-1);
			}
		}
	}
}
