class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) { return false; }
		if (s.length() == 0) { return true; }

		char[] sArr = s.toCharArray();

		int l = 0;
		int r = sArr.length-1;
		while (l < r) {
			while ( l < sArr.length &&
					!(('a' <= sArr[l] && sArr[l] <= 'z') ||
					  ('A' <= sArr[l] && sArr[l] <= 'Z') ||
					  ('0' <= sArr[l] && sArr[l] <= '9')) ) {
				l++;
			}
			while ( r >=0 &&
					!(('a' <= sArr[r] && sArr[r] <= 'z') ||
					  ('A' <= sArr[r] && sArr[r] <= 'Z') ||
					  ('0' <= sArr[r] && sArr[r] <= '9')) ) {
				r--;
			}
			if (l >= r) { break; }
			if (Character.toLowerCase(sArr[l]) != Character.toLowerCase(sArr[r])) {
				return false;
			}
			l++;
			r--;
		}

		return true;
    }
}
