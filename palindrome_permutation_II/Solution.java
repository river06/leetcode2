import java.util.*;
class Solution {
    public List<String> generatePalindromes(String s) {
		List<String> ret = new ArrayList<String>();
		if (s == null) {
			return ret;
		}
		if (s.length() == 0) {
			ret.add("");
			return ret;
		}
        // get if string can be palindrome permutation 
		int[] char2Occ = new int[256];
		int nSingle = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (char2Occ[c] % 2 == 0) {
				nSingle++;
			} else {
				nSingle--;
			}
			char2Occ[c] = char2Occ[c] + 1;
		}

		if (nSingle > 1) { return ret; }
		
		// build half of the string and find the single char
		char[] cArr = new char[s.length()/2];
		Character singleC = null;
		int p = 0;
		for (int c = 0; c < char2Occ.length; c++) {
			int occ = char2Occ[c];
			if (occ > 0) {
				if (occ % 2 == 1) {
					singleC = (char) c;
				}
				for (int i = 0; i < occ/2; i++) {
					cArr[p + i] = (char) c;
				}
				p += occ/2;
			}
		}
		// permutate to get all the permutations
		boolean[] isUsed = new boolean[cArr.length];
		StringBuilder sb = new StringBuilder();
		backTrack(cArr, isUsed, ret, sb, singleC);
		
		return ret;
    }

	private void backTrack(char[] cArr, boolean[] isUsed,
						   List<String> ret, StringBuilder sb, Character singleC) {
		// base case
		if (sb.length() >= cArr.length) {
			StringBuilder nsb = new StringBuilder(sb);
			ret.add(sb.toString() + (singleC == null ? "" : singleC) +
					nsb.reverse().toString());
			return;
		}
		for (int i = 0; i < cArr.length; i++) {
			if (!isUsed[i]) {
				if (i > 0 && cArr[i] == cArr[i-1] && !isUsed[i-1]) {
					continue;
				}
				isUsed[i] = true;
				sb.append(cArr[i]);
				backTrack(cArr, isUsed, ret, sb, singleC);
				sb.deleteCharAt(sb.length()-1);
				isUsed[i] = false;
			}
		}
	}
}
