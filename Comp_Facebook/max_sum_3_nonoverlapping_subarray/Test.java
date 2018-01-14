import java.util.*;
public class Test {
	public static void main(String[] args) {
		//int[] nums = {1,2,1,2,6,7,5,1};
		//int k = 2;

		// expects [1,4,7]
		int[] nums = {7,13,20,19,19,2,10,1,1,19};
		int k = 3;
		Solution solver = new Solution();
		int[] ret = solver.maxSumOfThreeSubarrays(nums, k);
		System.out.println(Arrays.toString(ret));
	}
}
