import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		//int[] nums = {1,3,5,4,7};
		int[] nums = {2, 3};
		int ret = solver.findLengthOfLCIS(nums);
		System.out.println(ret);
	}
}
