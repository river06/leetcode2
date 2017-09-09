import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		/*int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};*/
		int[] nums1 = {2,3,4,1,1,1};
		int[] nums2 = {1,2,2,1,3};
		int[] ret = solver.intersect(nums1, nums2);

		System.out.println( Arrays.toString( ret) );
	}
}
