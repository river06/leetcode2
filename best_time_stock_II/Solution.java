public class Solution {
    public int maxProfit(int[] prices) {
	
		if(prices==null) return 0;
		if(prices.length<2) return 0;
		int ret = 0;
		for(int i=0; i<prices.length-1; i++) {
			if(prices[i+1] - prices[i] > 0 ) {
				ret += prices[i+1] - prices[i];
			}
		}
		return ret;
	}
}