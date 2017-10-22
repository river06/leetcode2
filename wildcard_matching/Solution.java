class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) { return false; }

		boolean[][] ret = new boolean[s.length()+1][p.length()+1];

		ret[0][0] = true;
		for (int i=1; i<=s.length(); i++) {
			ret[i][0] = false;
		}
		boolean isTrue = true;
		for (int j=1; j<=p.length(); j++) {
			if (p.charAt(j-1) != '*') { isTrue = false; }
			ret[0][j] = isTrue;
		}

		for (int i=1; i<=s.length(); i++) {
			for (int j=1; j<=p.length(); j++) {
				if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
					ret[i][j] = ret[i-1][j-1];
				} else if (p.charAt(j-1) == '*') {
					ret[i][j] = ret[i-1][j] || ret[i][j-1] || ret[i-1][j-1];
				}
			}
		}

		return ret[s.length()][p.length()];
    }
}
