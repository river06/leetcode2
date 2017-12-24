class Solution {
    public int maxProfit(int[] prices, int fee) {
        int Tik0 = 0; // T(-1,k,0) = 0
		int Tik1 = Integer.MIN_VALUE; // T(-1,k,1) = -infinity

		for (int price: prices) {
			int Tik0pre = Tik0;
			int Tik1pre = Tik1;

			Tik0 = Math.max(Tik0pre, Tik1pre + price);
			Tik1 = Math.max(Tik1pre, Tik0pre - price - fee);
		}

		return Tik0;
    }
}
