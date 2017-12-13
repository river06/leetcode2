import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[] nums = {-2, 0, 1, 3};
		int target = 2;*/
		/*int[] nums = {3, 1, 0, -2};
		int target = 4;*/
		int[] nums = {3,2,-2,6,2,-2,6,-2,-4,2,3,0,4,4,1};
		int target = 3;
		System.out.println(solver.threeSumSmaller(nums, target));
	}
}
