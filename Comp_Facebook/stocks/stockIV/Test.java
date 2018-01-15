import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] prices = {7,1,5,3,6,4};
		//int k = 10;
		int k = 2;
		int[] prices = {3,3,5,0,0,3,1,4};
		int ret = solver.maxProfit(k, prices);

		System.out.println(ret);
	}
}
