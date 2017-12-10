class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) { return false; }
		if (s1.length() == 0 || s2.length() == 0) { return true; }

		if (s1.length() > s2.length()) {
			return false;
		}

		int[] letter2Occ = new int[26];
		int nChar = 0;
		for (int i=0; i<s1.length(); i++) {
			letter2Occ[s1.charAt(i) - 'a']++;
			nChar++;
		}
		int l = 0;
		int r = 0;
		while (r < s2.length()) {
			char c = s2.charAt(r);
			letter2Occ[c-'a']--;
			
			if (letter2Occ[c-'a'] >= 0) {
				nChar--;
				if (nChar == 0) {
					return true;
				}
			} else {
				while (l <= r) {
					char cl = s2.charAt(l);
					letter2Occ[cl - 'a']++;
					l++;

					if (letter2Occ[cl - 'a'] == 0) {
						break; 
					} else if (letter2Occ[cl - 'a'] > 0) {
						nChar++;
					}
				}
			}
			r++;
		}

		return false;
    }
}
