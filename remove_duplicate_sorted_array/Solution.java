public class Solution {
    public int removeDuplicates(int[] nums) {
		if( nums.length==0 ){ return 0; }
        if( nums.length<=1 ){ return nums[0]; }

		int p1=0;
		int p2=0;
		// find the first duplicate
		while( p1+1<nums.length && nums[p1]!=nums[p1+1]) {
			p1++;
		}
		// point p1 to the first duplicated position
		// out of boundary means no duplicate
		p1++;
		// point p2 to the starting position 
		p2 = p1+1;		   
		while( p2<nums.length ) {
			if( nums[p2] > nums[p1] && nums[p2]>nums[p1-1]) {
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
