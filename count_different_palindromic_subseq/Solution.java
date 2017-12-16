class Solution {
	private final int MOD = (int) Math.pow(10, 9) + 7;
    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() == 0) { return 0; }

		int[][][] DP = new int[S.length()][S.length()][4];

		for (int i=0; i<S.length(); i++) {
			DP[i][i][S.charAt(i)-'a'] = 1;
			if (i+1 < S.length()) {
				for (int j=0; j<4; j++) {
					DP[i][i+1][j] = S.charAt(i+1) - 'a' == j ?
						DP[i][i][j] + 1 : DP[i][i][j];
				}
			}
		}

		for (int i = S.length()-1; i>=0; i--) {
			for (int j=i+2; j<S.length(); j++) {
				for (int k=0; k<4; k++) {
					if (S.charAt(i) - 'a' != k) {
						DP[i][j][k] = DP[i+1][j][k];
					} else if (S.charAt(j) - 'a' != k) {
						DP[i][j][k] = DP[i][j-1][k];
					} else {
						DP[i][j][k] = 2;
						for (int l=0; l<4; l++) {
							DP[i][j][k] += DP[i+1][j-1][l];
							DP[i][j][k] %= MOD;
						}
					}
				}
			}
		}
		int ret = 0;
		for (int i=0; i<4; i++) {
			ret += DP[0][S.length()-1][i];
			ret %= MOD;
		}
		return ret;
    }
}
