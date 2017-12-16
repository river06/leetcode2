class Solution {
    public int longestPalindrome(String s) {
        int ret = 0;
		if (s == null) { return ret; }

		int[] char2Num = new int[52];
		int nOdd = 0;
		for (int i=0; i<s.length(); i++) {
			int idx = s.charAt(i);
			if (idx < 'a' || idx > 'z') {
				idx = idx - 'A' + 'z'-'a';
			} else {
				idx -= 'a';
			}
			if (char2Num[idx] % 2 == 1) {
				ret += 2;
				nOdd--;
			} else {
				nOdd++;
			}
			char2Num[idx]++;
		}
		if (nOdd > 0) { ret++; }
		return ret;
    }
}
