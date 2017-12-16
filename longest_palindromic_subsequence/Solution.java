class Solution {
    public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0) { return 0; }
        int[][] palinLength = new int[s.length()][s.length()];
		int maxLength = 1;
		for (int i=0; i<s.length(); i++) {
			palinLength[i][i] = 1;
			if (i+1 < s.length()) {
				palinLength[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
				maxLength = Math.max(maxLength, palinLength[i][i+1]);
			}
		}

		for (int i=s.length()-1; i>=0; i--) {
			for (int j=i+2; j<s.length(); j++) {
				palinLength[i][j] = Math.max(palinLength[i+1][j], palinLength[i][j-1]);
				int tmp = palinLength[i+1][j-1];
				if (s.charAt(i) == s.charAt(j)) { tmp += 2; }
				palinLength[i][j] = Math.max(palinLength[i][j], tmp);
				maxLength = Math.max(maxLength, palinLength[i][j]);
			}
		}

		return maxLength;
    }
}
