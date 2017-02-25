public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums.length<=2 ){ return nums.length; }
		
		int p1=2;
		int p2=0;

		// point p1 to the first duplicate
		while( p1<nums.length ) {
			if( nums[p1-2]==nums[p1-1] && nums[p1-1]==nums[p1] ) {
				break;
			}
			p1++;
		}
		p2 = p1+1;
		
		while( p2<nums.length ) {
			if( nums[p2]>nums[p1] && nums[p2]>nums[p1-2] ) {
				int tmp = nums[p2];
				nums[p2] = nums[p1];
				nums[p1] = tmp;
				p1++;
			}
			p2++;
		}
		return p1;
    }
}
