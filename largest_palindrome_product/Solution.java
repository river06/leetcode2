class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) { return 9; }
		int maxLeft = (int) Math.pow(10, n) - 1;
		for (int left = maxLeft - 2; left > maxLeft / 10; left--) {
			long palinVal = Long.parseLong(left +
				new StringBuilder().append(left).reverse().toString());
			for (int v1 = maxLeft; v1 >= palinVal/v1; v1--) {
				if (palinVal % v1 == 0) {
					return (int) (palinVal % 1337);
				}
			}
		}
		return 0;
    }
}
