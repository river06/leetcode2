import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		/*int[] nums = {-2, -1, 2, 1};
		int k = 1;*/

		int ret = solver.maxSubArrayLen(nums, k);

		System.out.println(ret);
	}
}
