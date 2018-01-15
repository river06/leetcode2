class Solution {
    public int maxProfit(int[] prices, int fee) {
        int Tik0 = 0;
		int Tik1 = Integer.MIN_VALUE;
		for (int price: prices) {
			Tik0 = Math.max(Tik0, Tik1 + price);
			Tik1 = Math.max(Tik1, Tik0 - price - fee);
		}

		return Tik0;
    }
}
