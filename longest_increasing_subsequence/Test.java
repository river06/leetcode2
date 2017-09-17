import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

		int ret = solver.lengthOfLIS(nums);

		System.out.println(ret);
	}
}
