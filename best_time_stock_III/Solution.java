public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null) return 0;
		if(prices.length<2) return 0;
		// solve this as one dimensional DP problem
		int[] best_l = new int[ prices.length];
		int[] best_r = new int[prices.length];

		// get best_l
		int min = prices[0];
		best_l[0]=0;
		for(int i=1; i<prices.length; i++) {
			best_l[i] = Math.max(best_l[i-1], prices[i]-min);
			if(min > prices[i]) min = prices[i];
		}

		int max = prices[prices.length-1];
		best_r[prices.length-1] = 0;
		for(int i=prices.length-2; i>=0; i--) {
			best_r[i] = Math.max(best_r[i+1], max - prices[i]);
			if(prices[i]>max) max = prices[i];
		}

		int ret = 0;
		for( int i=0; i<prices.length; i++) {
			ret = Math.max(ret, best_l[i]+best_r[i]);
		}
		return ret;
    }
}