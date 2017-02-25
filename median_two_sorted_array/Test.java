import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums1 = {2,3,4};
		int[] nums2 = {1};
		
		double ret = solver.findMedianSortedArrays(nums1, nums2);
		
		System.out.println(ret);
	}
}
