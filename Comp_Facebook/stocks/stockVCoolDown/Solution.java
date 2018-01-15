class Solution {
    public int maxProfit(int[] prices) {
        int Tik0 = 0;
		int Tim1k0 = 0;
		int Tik1 = Integer.MIN_VALUE;

		for (int i=0; i<prices.length; i++) {
			int oldTik0 = Tik0;
			Tik0 = Math.max(Tik0, Tik1 + prices[i]);
			Tik1 = Math.max(Tik1, Tim1k0 - prices[i]);
			Tim1k0 = oldTik0;
		}

		return Tik0;
    }
}
