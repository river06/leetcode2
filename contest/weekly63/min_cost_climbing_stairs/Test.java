import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] cost = {10, 15, 20};
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

		System.out.println(solver.minCostClimbingStairs(cost));
	}
}
