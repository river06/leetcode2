import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] prices = {1,2,3,0,2};
		int ret = solver.maxProfit(prices);

		System.out.println(ret);
	}
}
