import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] coins = {1, 2, 5};
		//int amount = 11;
		int[] coins = {2};
		int amount = 3;
		System.out.println( solver.coinChange(coins, amount) );
	}
}
