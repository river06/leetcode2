import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] prices = {7,1,5,3,6,4};
		int ret = solver.maxProfit(prices);

		System.out.println(ret);
	}
}
