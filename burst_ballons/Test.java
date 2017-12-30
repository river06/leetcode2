import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {3, 1, 5, 8};
		int coins = solver.maxCoins(nums);
		System.out.println(coins);
	}
}
