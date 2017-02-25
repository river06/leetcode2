import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {2};
		int target = 9;
		int[] ret = solver.twoSum(nums, target);

		for(int num: ret) {
			System.out.println(num);
		}
	}
}
