import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) { return s; }
		int sLength = s.length();
		char[] ret = new char[sLength];
		char[] sArr = s.toCharArray();
		int idx = 0;
		for (int j=0; j<numRows; j++) {
			int k = 0;
			while (true) {
				int idx1 = 2*(numRows-1) * k + j;
				if ( idx1 >= sLength) {
					break;
				} else {
					ret[idx] = sArr[idx1];
					idx++;
				}

				int idx2 = 2*(numRows-1) * (k+1) - j;
				if (idx2 >= sLength) {
					break;
				} else if (idx1 != idx2 && idx2 != 2*(numRows-1) * (k+1) + j) {
					ret[idx] = sArr[idx2];
					idx++;
				}
				k++;
			}
		}

		return new String(ret);
    }
}
