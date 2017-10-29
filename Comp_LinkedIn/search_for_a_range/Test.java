import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 9;
		int[] ret = solver.searchRange(nums, target);

		System.out.println(Arrays.toString(ret));
	}
}
