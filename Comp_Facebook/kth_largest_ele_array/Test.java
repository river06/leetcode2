import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {3,2,1,5,6,4};
		int k = nums.length;
		//int[] nums = {2,2,2,2,2};
		//int k = nums.length;

		System.out.println(solver.findKthLargest(nums, k));
	}
}
