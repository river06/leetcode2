class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) { return true; }

		int[] char2Occ = new int[256];
		int nSingle = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			char2Occ[c] = (char2Occ[c] + 1) % 2;
			if (char2Occ[c] == 1) {
				nSingle++;
			} else {
				nSingle--;
			}
		}
		return nSingle <= 1;
    }
}
