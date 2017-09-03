class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] isMatchNow = new boolean[s.length()+1][p.length()+1];
        isMatchNow[0][0] = true;
		// first row is special
		for (int j=1; j<=p.length(); j++) {
			if (p.charAt(j-1) == '*') {
				isMatchNow[0][j] = isMatchNow[0][j-2];
			}
		}
		// first column is default to false (Java)

        for (int i=1; i<=s.length(); i++) {
        	for (int j=1; j<=p.length(); j++) {
				if (isEqual(s.charAt(i-1), p.charAt(j-1))) {
					// c can not be '*' in this case
					isMatchNow[i][j] = isMatchNow[i-1][j-1];
        		} else if (p.charAt(j-1)=='*') {
					// we need to consider 0 time, 1 time and multiple time
					isMatchNow[i][j] = isMatchNow[i][j-2] || 
						isMatchNow[i][j-1] || 
						(isMatchNow[i-1][j] && isEqual(s.charAt(i-1), p.charAt(j-2)));
				}
				// other case is false
        	}
        }

        return isMatchNow[s.length()][p.length()];

    }

    private boolean isEqual(Character c1, Character c2) {
    	if (c2 == '.') { 
    		return true;
    	} else {
    		return c1 == c2;
    	}
    }
}
