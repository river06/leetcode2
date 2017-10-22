class Solution {
    /*public boolean checkValidString(String s) {
        if (s == null) { return false; }
		if (s.length() == 0) { return true; }
		char[] sArr = s.toCharArray();
		return dfs(sArr, 0, 0);
    }

	public boolean dfs(char[] sArr, int idx, int nOpen) {
		if (nOpen < 0) { return false; }
		if (idx == sArr.length) {
			return nOpen == 0;
		}

		boolean[] ret = new boolean[3];
		if (sArr[idx] == '(' || sArr[idx] == '*') {
			ret[0] = dfs(sArr, idx+1, nOpen+1);
		}
		if (sArr[idx] == ')' || sArr[idx] == '*') {
			ret[1] = dfs(sArr, idx+1, nOpen-1);
		}
		if (sArr[idx] == '*') {
			ret[2] = dfs(sArr, idx+1, nOpen);
		}

		return ret[0] || ret[1] || ret[2];
	}*/
	public boolean checkValidString(String s) {
        if (s == null) { return false; }
		char[] sArr = s.toCharArray();
		int nMin = 0;
		int nMax = 0;
		for (int i=0; i<sArr.length; i++) {
			if (sArr[i] == '(') {
				nMin++;
				nMax++;
			}
			if (sArr[i] == ')') {
				nMin = Math.max(0, nMin-1);
				nMax--;
			}
			if (sArr[i] == '*') {
				nMin = Math.max(0, nMin-1);
				nMax++;
			}
			if (nMax < 0) { return false; }
		}
		System.out.println(nMin + "| " + nMax);
		return (nMin <= 0 && 0 <= nMax);
    }
}
