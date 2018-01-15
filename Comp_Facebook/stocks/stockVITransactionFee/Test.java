import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		int ret = solver.maxProfit(prices, fee);

		System.out.println(ret);
	}
}
