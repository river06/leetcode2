class Solution {
	/**
	 * Expand from center algorithm
	 */
    public String longestPalindrome(String s) {
		String result = new String();
		int r1 = 0, r2 = 0;
		int maxLength = 0;
        if (s.length() == 0) { return result; }
		for (int i=0; i<s.length(); i++) {
			// need to search for center at i and center at [i,i+1]
			int tmpLength = palindromeHelper(s, i, i);
			if (tmpLength > maxLength) {
				maxLength = tmpLength;
				r1 = i - (tmpLength-1)/2;
				r2 = i + (tmpLength-1)/2;
			}

			if (i+1 < s.length()) {
				tmpLength = palindromeHelper(s, i, i+1);
				if (tmpLength > maxLength) {
					maxLength = tmpLength;
					r1 = i - (tmpLength-2)/2;
					r2 = i+1 + (tmpLength-2)/2;
				}
			}
		}
		return s.substring(r1, r2+1);
    }

	private int palindromeHelper(String s, int p1, int p2) {
		while ( p1 >=0 && p2 < s.length() ) {
			if ( s.charAt(p1) != s.charAt(p2) ) {
				break;
			}
			p1--;
			p2++;
		}
		return Math.max(0, p2-p1-1);
	}
}
