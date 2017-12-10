import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] nums = {1,3,1,2,0,5};
		int k = 3;
		int[] ret = solver.maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ret));
	}
}
