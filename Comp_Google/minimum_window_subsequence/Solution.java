import java.util.*;

class Solution {
    public String minWindow(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
			return "";
		}

		// DP[i][j] is the starting index of minimum substring
		int[][] DP = new int[S.length()][T.length()];

		for (int i=0; i<DP.length; i++) {
			Arrays.fill(DP[i], -1);
		}

		for (int i=0; i<DP.length; i++) {
			if (S.charAt(i) == T.charAt(0)) {
				DP[i][0] = i;
			} else if (i > 0) {
				DP[i][0] = DP[i-1][0];
			}
		}

		for (int i=1; i<DP.length; i++) {
			for (int j=1; j<DP[0].length; j++) {
				if (S.charAt(i) == T.charAt(j)) {
					DP[i][j] = DP[i-1][j-1];
				} else {
					DP[i][j] = DP[i-1][j];
				}
			}
		}


		// find the answer
		int l = -1;
		int minLength = Integer.MAX_VALUE;
		for (int i=0; i<DP.length; i++) {
			int start = DP[i][T.length()-1];
			if (start != -1 && i-start+1 < minLength) {
				l = start;
				minLength = i-start+1;
			}
		}
		return l == -1 ? "" : S.substring(l, l+minLength);
    }
}
