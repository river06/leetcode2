public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		
		int ret1 = getKthNum(nums1, 0, nums2, 0, (m+n)/2+1);
		
		if ((m+n)%2==1) {
			// odd, return the middle one
			return ret1;
		} else {
			// even return the average of the middle two
			int ret2 = getKthNum(nums1, 0, nums2, 0, (m+n)/2);
			return (ret1+ret2)/2.0;
		}
    }
	/** 
	 * Helper function to get the kth number of two sorted array.
	 * k is one based
	 */
	private int getKthNum(int[] A, int pa, int[] B, int pb, int k) {
		
		// base cases 
		if( pa >= A.length ) return B[pb+k-1];
		if( pb >= B.length ) return A[pa+k-1];
		if( k==1 ) return Math.min( A[pa], B[pb] ); // since k-k/2 won't change
		
		if( pa+k/2-1 >= A.length ) {
			return getKthNum(A, pa, B, pb+(k-k/2), k/2);
		} else if ( pb+(k-k/2)-1 >= B.length ) {
			return getKthNum(A, pa+k/2, B, pb, k-k/2);
		} else {
			int AEndVal = A[pa+k/2-1];
			int BEndVal = B[pb+(k-k/2)-1];
			if( AEndVal > BEndVal ) {
				return getKthNum(A, pa, B, pb+(k-k/2), k/2);
			} else if ( AEndVal<BEndVal ) {
				return getKthNum(A, pa+k/2, B, pb, k-k/2);
			} else {
				return AEndVal;
			}
		}
		
	}
}