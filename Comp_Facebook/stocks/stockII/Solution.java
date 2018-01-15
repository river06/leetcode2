class Solution {
    public int maxProfit(int[] prices) {
		int Tik0 = 0;
		int Tik1 = Integer.MIN_VALUE;

		for (int i=0; i<prices.length; i++) {
			int t0 = Tik0;
			int t1 = Tik1;

			Tik0 = Math.max(t0, t1 + prices[i]);
			Tik1 = Math.max(t1, t0 - prices[i]);
		}

		return Tik0;
    }
}
