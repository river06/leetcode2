import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums0 = {1,2,3};
		int[] nums2 = {4,5,6};
		int[] nums1 = new int[nums0.length+nums2.length];
		for(int i=0; i<nums0.length; i++) {
			nums1[i] = nums0[i];
		}
		int m = nums0.length;
		int n = nums2.length;

		solver.merge(nums1, m, nums2, n);

		System.out.println( Arrays.toString( nums1 ));
	}
}
