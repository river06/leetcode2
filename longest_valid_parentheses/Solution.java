import java.util.*;
class Solution {

	public int longestValidParentheses(String s) {
		// using stack to keep track of the first invalid position
		// and last position of ( before valid substring
		int maxL = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.isEmpty()) {
					st.push(i);
				} else {
					maxL = Math.max(maxL, i-st.peek());
				}
			}
		}
		return maxL;
					
	}
	
	// this should be O(n) time and O(n) space. Still get TLE. I guess O(n) space takes
	// time
    /*public int longestValidParentheses(String s) {
		int sLength = s.length();
		char[] sArr = s.toCharArray();
        if (s == null || sLength < 2) {
			return 0;
		}

		// number of max valid substring ending at i
		int[] dp = new int[sLength];
		dp[0] = 0;
		dp[1] = sArr[0] == '(' && sArr[1] == ')' ? 2 : 0;
		int maxLength = dp[1];
		for (int i=2; i<sLength; i++) {
			if (sArr[i] == '(') { continue; }

			if (sArr[i-1] == '(') {
				dp[i] = dp[i-2] + 2;
			} else if (i-1-dp[i-1] >= 0 && sArr[i-1-dp[i-1]] == '(') {
				dp[i] = dp[i-1] + 2;
				if (i-1-dp[i-1]-1 >= 0) {
					dp[i] += dp[i-1-dp[i-1]-1];
				}
			}
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}*/
}
