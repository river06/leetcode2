class Solution {
    public int maxProfit(int[] prices) {
        int Ti10 = 0;
		int Ti11 = Integer.MIN_VALUE;

		for (int i=0; i<prices.length; i++) {
			Ti10 = Math.max(Ti10, Ti11 + prices[i]);
			Ti11 = Math.max(Ti11, -prices[i]);
		}

		return Ti10;
    }
}
