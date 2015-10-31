public class Solution {
    public int numDistinct(String s, String t) {
        /*
		  2D DP
		  Formula:
		  Let Q(m,n) denote the number of different subsequences
		  for the first m char in s and n char in t.
		  Q(m,n) = Q(m-1,n) + Q(m-1,n-1)*1(s_m==t_n?).
		*/
		int m = s.length();
		int n = t.length();
		int[][] DP = new int[m+1][n+1];
		for(int i=0; i<=m; i++) DP[i][0] = 1;
		for(int j=0; j<n; j++) {
			for(int i=0; i<m; i++) {
				DP[i+1][j+1] = DP[i][j+1];
				if( s.charAt(i) == t.charAt(j) ) {
					DP[i+1][j+1] += DP[i][j];
				}
			}
		}
		return DP[m][n];
    }
}
