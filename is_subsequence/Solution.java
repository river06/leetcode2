class Solution {
    public boolean isSubsequence(String s, String t) {
        // dynamic programming
	   
		boolean[][] dp = new boolean[2][t.length()+1];
 
		// first row is true
		for (int j=0; j<=t.length(); j++) {
			dp[0][j] = true;
		}

		for (int i=1; i<=s.length(); i++) {
			dp[i%2][0] = false;
			for (int j=1; j<=t.length(); j++) {
				if ((dp[1-i%2][j-1] && s.charAt(i-1) == t.charAt(j-1))
					|| dp[i%2][j-1]) {
					dp[i%2][j] = true;
				} else {
					dp[i%2][j] = false;
				}
			}
			
		}
		return dp[s.length()%2][t.length()];
    }
}
