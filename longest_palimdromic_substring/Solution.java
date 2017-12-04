class Solution {
    public String longestPalindrome(String s) {
        // special case
		if (s == null || s.length() == 0) { return s; }
        // Dynamic programming solution
		// DP(i, j) represents if substring (i, j) is palindromic
		// DP(i, j) depends on DP(i+1, j-1)
		int l = 0, r = 0;
		int maxLength = 1;
		boolean[][] DP = new boolean[s.length()][s.length()];

		// initialize base case
		for (int i=0; i<s.length(); i++) {
			DP[i][i] = true;
		}

		// DP
		for (int i = s.length()-1; i >= 0; i--) {
			for (int j = i+1; j < s.length(); j++) {
				if (j == i+1) {
					DP[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					DP[i][j] = DP[i+1][j-1] && (s.charAt(i) == s.charAt(j));
				}
				if (DP[i][j] && j-i+1 > maxLength) {
					maxLength = j-i+1;
					l = i;
					r = j;
				}
			}
		}
		
		return s.substring(l, r+1);
    }
}
