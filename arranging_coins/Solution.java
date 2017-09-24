class Solution {
    public int arrangeCoins(int n) {
        if (n<=1) { return n; }

		int ret = (int) ((Math.sqrt( 8*(long)n + 1 ) - 1)/2);
		return ret;
    }
}
