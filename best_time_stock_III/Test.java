public class Test {
	public static void main (String[] args) {
		Solution solver = new Solution();
		int[] prices = {0,1,2,0,1,2};
		int ret = solver.maxProfit(prices);

		System.out.println(ret);
	}
}