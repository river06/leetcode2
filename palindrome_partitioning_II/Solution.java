class Solution {
    public int minCut(String s) {
		// special cases
		if (s == null || s.length() == 0) {
			return 0;
		}
		
        // DP
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];

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

		// DP left
		int[] minParLeft = new int[s.length()];
		for (int end=0; end<s.length(); end++) {
			if (isPalindrome[0][end]) {
				minParLeft[end] = 0;
			} else {
				minParLeft[end] = Integer.MAX_VALUE;
				for (int start = end; start > 0; start--) {
					if (isPalindrome[start][end]) {
						minParLeft[end] = Math.min(minParLeft[end],
												   minParLeft[start-1] + 1);
					}
				}
			}
		}

		return minParLeft[s.length()-1];
    }
}
