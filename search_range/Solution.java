public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1, -1};
		if( nums.length==0 ){ return ret; }
	    if( nums[0]>target || nums[nums.length-1]<target){ return ret; }
		
		int p1=0; 
		int p2=nums.length-1;
		
		// find left
		while(p1<p2) {
			int pm = p1 + (p2-p1)/2;
			if( nums[pm] >= target ) {
				p2=pm;
			} else {
				p1=pm+1;
			}
		}
		if( nums[p1]==target ) {
			ret[0] = p1;
		} else {
			return new int[]{-1,-1};
		}
		
		p1=0; 
		p2=nums.length-1;
		
		// find right
		while(p1<p2) {
			int pm = p1 + (p2-p1+1)/2;
			if( nums[pm] <= target ) {
				p1=pm;
			} else {
				p2=pm-1;
			}
		}
	    ret[1] = p2;
		return ret;
    }
}