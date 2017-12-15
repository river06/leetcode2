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
		char[] cArr = new char[s.length()];
		int p = 0;
		for (int c = 0; c < char2Occ.length; c++) {
			int occ = char2Occ[c];
			if (occ > 0) {
				if (occ % 2 == 1) {
					cArr[cArr.length / 2] = (char) c;
				}
				for (int i = 0; i < occ/2; i++) {
					cArr[p + i] = (char) c;
				}
				p += occ/2;
			}
		}
		// permutate to get all the permutations
		backTrack(cArr, 0, cArr.length/2, ret);
		
		return ret;
    }

	private void backTrack(char[] cArr, int start, int length, List<String> ret) {
		// base case
		if (start >= length) {
			ret.add(getString(cArr));
		}
		for (int i = start; i < length; i++) {
			if (i == start || cArr[i] != cArr[start]) {
				swap(cArr, i, start);
				backTrack(cArr, start + 1, length, ret);
				swap(cArr, i, start);
			}
		}
	}

	public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
	
	private String getString(char[] cArr) {
		char[] newArr = new char[cArr.length];
		int l = 0;
		int r = newArr.length-1;
		while (l <= r) {
			newArr[l] = cArr[l];
			newArr[r] = cArr[l];
			l++;
			r--;
		}
		return new String(newArr);
	}
}
