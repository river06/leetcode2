public class Solution {
    public int search(int[] nums, int target) {
        if( nums.length<=0 ){ return -1; }
		int p1 = 0;
		int p2 = nums.length-1;
		
		while( p1<p2 ) {
			int val1 = nums[p1];
			int val2 = nums[p2];
			int pm = p1 + (p2-p1)/2; // p1~pm, pm+1~p2
			int valm = nums[pm];
			if( valm==target ) { return pm; }
			if( val1<val2 ) {
				if( val1<=target && target<=valm ) {
					p2 = pm;
				} else if( valm<=target && target<=val2 ) {
					p1 = pm+1;
				} else {
					return -1;
				}
			} else if( val1<=valm ) {
				if( val1<=target && target<=valm ) {
					p2 = pm;
				} else {
					p1 = pm+1;
				}
			} else {
				if( valm<=target && target<=val2 ) {
					p1 = pm+1;
				} else {
					p2 = pm;
				}
			}
		}
		
		if( nums[p1] == target ) { 
			return p1; 
		} else {
			return -1;
		}
    }
}