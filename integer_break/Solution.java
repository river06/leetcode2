import java.util.*;
public class Solution {
    public int integerBreak(int n) {
        int[] DP = new int[n];
        
        DP[0] = 1;
        for( int i=1; i<n; i++) { // i presents i+1
            int max_prod = Integer.MIN_VALUE;
            for(int j=0; j<i; j++) { // j represents i+1-(j+1)
                max_prod = Math.max(DP[j] * (i-j), max_prod);
                max_prod = Math.max(max_prod, (j+1)*(i-j));
            }
            DP[i] = max_prod;
        }
        return DP[n-1];
    }
}