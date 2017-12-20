import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {23, 2, 4, 6, 7};
		//int[] nums = {23, 2, 6, 4, 7};
		//int[] nums = {2, 1, 3};
		int[] nums = {0, 1, 0, 1, 1, 1, 0, 0};
		int k = 0;

		boolean ret = solver.checkSubarraySum(nums, k);

		System.out.println(ret);
	}
}
