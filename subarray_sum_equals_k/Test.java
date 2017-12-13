import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[] nums = {1, 1, 1};
		int k = 3;*/
		int[] nums = {-1, 1, -1, 1, -1, 1};
		int k = 0;

		System.out.println(solver.subarraySum(nums, k));
	}
}
