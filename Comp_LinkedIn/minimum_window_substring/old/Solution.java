import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return "";
		}

		// construct map here
		int counter = 0;
		int[] tMap = new int[256];
		for (char c: t.toCharArray()) {
			tMap[c]++;
			counter++;
		}

		int l=0;
		int r=0;
		int lRet = -1;
		int rRet = -1;
		int minDis = Integer.MAX_VALUE;
			
		char[] sArr = s.toCharArray();
		String ret = "";
		
		while (r < sArr.length) {
			// update counter and Map
			if (tMap[sArr[r]] > 0) {
				counter--;
			}
			tMap[sArr[r]]--;
			r++;
			
			while (counter == 0) {
				if (r-l < minDis) {
					lRet = l;
					rRet = r;
					minDis = r - l;
				}

				if (tMap[sArr[l]] >= 0) {
					counter++;
				}
				
				tMap[sArr[l]]++;
				l++;
			}
		}
		if (lRet >= 0) {
			ret = s.substring(lRet, rRet);
		}
		return ret;
    }
}
