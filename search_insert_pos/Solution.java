public class Solution {
    public int searchInsert(int[] nums, int target) {
        int p1 = 0;
		int p2 = nums.length-1;
		
		while( p1<p2 ){
			int pm = p1+(p2-p1)/2;
			if( nums[pm]==target ){ 
				return pm; 
			} else if( nums[pm]>target ){
				p2=pm;
			} else {
				p1=pm+1;
			}
		}
		if( nums[p1]>=target ){
			return p1;
		} else {
			return p2+1;
		}
    }
}