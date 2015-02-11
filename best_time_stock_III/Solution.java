public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null) return 0;
		ir(prices.length<2) return 0;
		
		int[] prifits = new int[2];
		int p1 = 0;
		int p2 = 1;
		while(p2<prices.length) {
			if( prices[p2] <= prices[p2-1]
    }
}