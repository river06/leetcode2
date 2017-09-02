class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) { return true; }
        boolean[][] isMatchNow = new boolean[s.length()+1][p.length()+1];
        isMatchNow[0][0] = true;
        for (int i=1; i<=s.length(); i++) {
        	isMatchNow[i][0] = false;
        }

        for (int i=0; i<=s.length(); i++) {
        	for (int j=1; j<=p.length(); j++) {
        		if (p.charAt(j-1)!='*') {
        			if (i==0) {
        				isMatchNow[i][j] = false;
        			} else if (isEqual(s.charAt(i-1), p.charAt(j-1))) {
        				isMatchNow[i][j] = isMatchNow[i-1][j-1];
        			} else {
        				isMatchNow[i][j] = false;
        			}
        		} else {
        			if (isMatchNow[i][j-2]) { 
        				isMatchNow[i][j] = true;
        			} else {
        				for (int k=i; k>0; k--) {
	        				if (isEqual(s.charAt(k-1), p.charAt(j-2))) {
	        					if (isMatchNow[k][j-1]) {
	        						isMatchNow[i][j] = true;
	        						break;
	        					} 
	        				} else {
	        					isMatchNow[i][j] = false;
	        					break;
	        				}
	        			}
        			}
        		}
        	}
        }

        return isMatchNow[s.length()][p.length()];

    }

    private boolean isEqual(Character c1, Character c2) {
    	if (c2=='.') { 
    		return true;
    	} else {
    		return c1==c2;
    	}
    }
}