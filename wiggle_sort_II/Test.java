import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();

		//int[] nums = {1,5,1,1,6,4};
		//int[] nums = {1,3,2,2,3,1};
		//int[] nums = {1,1,2,2,2,1};
		// int[] nums = {1,3,2,2,3,1};
		int[] nums = {2,1};
		// int[] nums = {1,2};
		solver.wiggleSort(nums);
		System.out.println( Arrays.toString(nums) );

	}
}
