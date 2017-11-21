import java.util.*;
class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        // try backtracking algorithm
	Map<Character, String> char2Bound = new HashMap<Character, String>();
	Set<String> used = new HashSet<String>();
	boolean ret = helper(pattern, 0, str, 0, char2Bound, used);
	return ret;
    }
    private boolean helper(String pattern, int ip, String str, int is,
			   Map<Character, String> char2Bound, Set<String> used) {
	// base case
	if (ip == pattern.length() || is == str.length()) {
	    if (ip != pattern.length() || is != str.length()) {
		return false;
	    } else {
		return true;
	    }
	}
	Character cp = pattern.charAt(ip);
	if (char2Bound.containsKey(cp) ) {
	    String sp = char2Bound.get(cp);
	    if (!str.startsWith(sp, is)) {	    
		return false;
	    } else {
		return helper(pattern, ip+1, str, is+sp.length(), char2Bound, used);
	    }
	} else {
	    // backtracking
	    for (int r=is; r<str.length(); r++) {
		String ss = str.substring(is, r+1);
		if (!used.contains(ss)) {
		    char2Bound.put(cp, ss);
		    used.add(ss);
		    boolean tmpRet = helper(pattern, ip+1, str, r+1, char2Bound, used);
		    if (tmpRet) { return true; }
		    char2Bound.remove(cp);
		    used.remove(ss);
		}
	    }
	    return false;
	}
    }
}
