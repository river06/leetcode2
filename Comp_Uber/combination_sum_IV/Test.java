import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1, 2, 3};
		int target = 32;
		int ret = solver.combinationSum4(nums, target);
		System.out.println(ret);
	}
}
