class Solution {
    public int coinChange(int[] coins, int amount) {
        if ( coins==null || coins.length <= 0 ) { return -1; }
		// 1D DP algorithm
		// DP[i] stores the minimum number of coins for amount i
		int[] DP = new int[amount+1];
		for (int i=1; i<=amount; i++) { DP[i] = amount+1; }
		DP[0] = 0;
		for (int i=1; i<=amount; i++) {
			// loop through coins
			for (int coin: coins) {
				if ( i-coin >= 0 ) {
					DP[i] = Math.min( DP[i], DP[i-coin] + 1 );
				}
			}
		}
		return DP[amount] > amount ? -1 : DP[amount];
    }
}
