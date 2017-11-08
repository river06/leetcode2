class Solution {
    public String minWindow(String s, String t) {
        String ret = "";
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return ret;
		}

		int minLength = Integer.MAX_VALUE;
		int lRet = -1;
		int rRet = -1;
		int l = 0;
		int r = 0;
		int nLeft = t.length();
		int[] map = new int[256];
		for (int i=0; i<t.length(); i++) {
			map[t.charAt(i)]++;
		}
		
		char[] sArr = s.toCharArray();
		
		while (r < sArr.length) {
			if (map[sArr[r]] > 0) {
				nLeft--;
			}
			map[sArr[r]]--;
			if (nLeft == 0) {
				while(l <= r) {
					map[sArr[l]]++;
					if (map[sArr[l]] > 0) {
						nLeft++;
						l++;
						break;
					}
					l++;
				}
				int curLength = r-l+2;
				if (curLength < minLength) {
					lRet = l-1;
					rRet = r;
					minLength = curLength;
				}
			}
			r++;
		}
		if (lRet >= 0) {
			ret = s.substring(lRet, rRet+1);
		}
		return ret;
    }
}
