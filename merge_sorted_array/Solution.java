public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge from back to front
		int p0 = m+n-1;
		int p1 = m-1;
		int p2 = n-1;

		while( p1>=0 && p2>=0 ) {
			nums1[p0--] = nums1[p1]>=nums2[p2] ?
				nums1[p1--] : nums2[p2--];
		}

		while( p2>=0 ) {
			nums1[p0--] = nums2[p2--];
		}
    }
}