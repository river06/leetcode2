class Solution {
    public int numDecodings(String s) {
		if (s== null || s.length() == 0) {
			return 0;
		}
        char[] cArr = s.toCharArray();
		
		int[] dp = new int[s.length()+1];
		dp[0] = 1;

		for (int i=0; i<s.length(); i++) {
			dp[i+1] = cArr[i] == '0' ? 0 : dp[i];
			if (i>=1) {
				int code = (cArr[i-1] - '0') * 10 + cArr[i]-'0';
				if (code >= 10 && code <= 26) {
					dp[i+1] += dp[i-1];
				}
			}
		}

		return dp[s.length()];
    }
}
