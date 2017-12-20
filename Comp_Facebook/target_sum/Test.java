import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1, 1, 1, 1, 1};
		int S = 3;

		int ret = solver.findTargetSumWays(nums, S);

		System.out.println(ret);
	}
}
