public class Solution {
    public boolean canJump(int[] nums) {
        if( nums.length <=1 ) { return true; }
        int p1 = 0;
        int p2 = nums[0];

        while( p1<=p2 ) {
        	if( p2 >= nums.length-1 ) {
        		return true;
        	}

        	p2 = Math.max(p2, p1+nums[p1]);
        	p1++;
        }

        return false;
    }
}