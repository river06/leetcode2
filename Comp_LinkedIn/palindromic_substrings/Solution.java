import java.util.*;

class Solution {
    public int countSubstrings(String s) {
		// base case
		if (s == null || s.length() == 0) { return 0; }
        // pre process
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i=0; i<s.length(); i++) {
			sb.append( s.charAt(i) );
			sb.append("#");
		}
		String ss = sb.toString();
		int ret = 0;
		// find all the palindromes
		for (int i=0; i<ss.length(); i++) {
			ret += findLongestPan(ss, i);
		}
		return ret;
    }

	private int findLongestPan(String ss, int idx) {
		int i = 0;
		while (idx-i >= 0 && idx+i < ss.length()) {
			if (ss.charAt(idx-i) != ss.charAt(idx+i)) {
				break;
			}
			i++;
		}
		return i/2;
	}
}
