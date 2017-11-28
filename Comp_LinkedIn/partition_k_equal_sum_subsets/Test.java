import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {4, 3, 2, 3, 5, 2, 1};
		//int[] nums = {1,1,1,1,3,3,3,3};
		//int k = 4;

		//int[] nums = {3522,181,521,515,304,123,2512,312,922,
		//			   407,146,1932,4037,2646,3871,269};
		//int k = 5;
		int[] nums = {85,35,40,64,86,45,63,16,5364,110,5653,97,95};
		int k = 7;
		boolean ret = solver.canPartitionKSubsets(nums, k);
		System.out.println(ret);
	}
}
