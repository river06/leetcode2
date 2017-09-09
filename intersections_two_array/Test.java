import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};

		int[] ret = solver.intersection(nums1, nums2);
		System.out.println( Arrays.toString( ret ) );
	}
}
