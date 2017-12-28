class Solution {
	private static int MOD = 1000000007;
    public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		StringBuilder sb = new StringBuilder(s);

		long[] dp = new long[sb.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		if (sb.charAt(0) == '*') { dp[1] = 9; }
		if (sb.charAt(0) == '0') { dp[1] = 0; }

		for (int i=1; i<sb.length(); i++) {
			if (sb.charAt(i) == '*') {
				long self = (dp[i+1-1] * 9) % MOD;
				int doubleM = 0;
				if (sb.charAt(i-1) == '1') { doubleM = 9; }
				if (sb.charAt(i-1) == '2') { doubleM = 6; }
				if (sb.charAt(i-1) == '*') { doubleM = 15; }
				long both = (dp[i+1 - 2] * doubleM) % MOD;
				dp[i+1] = (self + both) % MOD;
			} else if (sb.charAt(i) == '0'){
				if (sb.charAt(i-1) == '1' || sb.charAt(i-1) == '2') {
					dp[i+1] = dp[i+1-2];
				} else if (sb.charAt(i-1) == '*') {
					dp[i+1] = (dp[i+1-2] * 2) % MOD;
				} else {
					dp[i+1] = 0;
				}
			}
			else {
				long self = dp[i+1 -1];
				int doubleM = 0;
				if (sb.charAt(i-1) == '1' ||
					(sb.charAt(i-1) =='2' && sb.charAt(i)<='6')) {
					doubleM = 1;
				}
				if (sb.charAt(i-1) == '*') {
					doubleM = sb.charAt(i) <= '6' ? 2 : 1;
				}
				long both = dp[i+1 - 2] * doubleM;
				dp[i+1] = (self + both) % MOD;
			}
		}

		return (int) dp[sb.length()];
    }
}
