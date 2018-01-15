import java.util.*;
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
			int ret = 0;
			for (int i=1; i<prices.length; i++) {
				if (prices[i] > prices[i-1]) {
					ret += prices[i] - prices[i-1];
				}
			}
			return ret;
		} else {
			int[] T0 = new int[k+1];
			int[] T1 = new int[k+1];
			Arrays.fill(T1, Integer.MIN_VALUE);

			for (int i=0; i<prices.length; i++) {
				int[] N0 = new int[k+1];
				int[] N1 = new int[k+1];
				//N1[0] = Integer.MIN_VALUE;

				for (int t=1; t<=k; t++) {
					N0[t] = Math.max(T0[t], T1[t] + prices[i]);
					N1[t] = Math.max(T1[t], T0[t-1] - prices[i]);
				}
				T0 = N0;
				T1 = N1;
			}

			return T0[k];
		}
    }
}
