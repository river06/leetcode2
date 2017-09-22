import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		/*int[] nums = {7,2,5,10,8};
		int m = 2;*/

		/*int[] nums = {7,2,5,10,8};
		int m = 1;*/
		//int[] nums = {7,2,5,10,8};

		int[] nums = {1, Integer.MAX_VALUE};
		for (int m=1; m<=nums.length; m++) {
			int ret = solver.splitArray(nums, m);

			System.out.println(m + ": " + ret);
		}
	}
}
