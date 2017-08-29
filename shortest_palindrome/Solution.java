class Solution {
    public String shortestPalindrome(String s) {
        // brute force: reverse the string and compare beginning and end
		// KMP: build the s + # + inverse(s), and find the longest prefix = surfix
		// two pointer: interesting algorithm using the counting property
		int palinLength = this.helper(s, s.length());
		String firstPart = new StringBuilder(s.substring(palinLength, s.length())).reverse().toString();
		return firstPart + s;
    }
	/**
	 * Return the length of the largest palindrome from the beginning
	 */
	private int helper(String s, int sLength) {
		int pe = sLength-1;
		int ps = 0;
		while (pe>=0) {
			if (s.charAt(ps) == s.charAt(pe)) {
				ps++;
			}
			pe--;
		}
		if (ps == sLength) {
			return sLength;
		} else {
			return helper(s, ps);
		}
	}
}
