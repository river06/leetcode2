import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {1,3,5,4,7};
		int[] nums = {1,2,4,3,5,4,7,2};
		//int[] nums = {2,2,2,2,2};
		int ret = solver.findNumberOfLIS(nums);

		System.out.println(ret);
	}
}
