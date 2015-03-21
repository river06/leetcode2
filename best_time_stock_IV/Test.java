public class Test{
	public static void main(String[] args) {
		Solution solver = new Solution();
		int k = 3;
		int[] prices = {1,2,3};
		int ret = solver.maxProfit(k, prices);
		System.out.println(ret);
	}
}