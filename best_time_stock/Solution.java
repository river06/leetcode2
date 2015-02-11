public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null) return 0;
		if(prices.length<2) return 0;
		
		int p1 = 0;
		int p2 = 0;
		int ret = 0;
		while( p2 < prices.length ) {
			if( prices[p2] <= prices[p1] ) {
				p1 = p2;
			} else {
				if( prices[p2] - prices[p1] > ret ) {
					ret = prices[p2] - prices[p1];
				}
			}
			
			p2 ++;
		}
		return ret;
    }
}