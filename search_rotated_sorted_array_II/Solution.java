public class Solution {
    public boolean search(int[] nums, int target) {
        boolean ret = false;
		if( nums.length<=0 ){ return ret; }
		
		int p1=0;
		int p2=nums.length-1;

		while (p1<p2-1) {
			int pm = p1 + (p2-p1)/2; // p1~pm-1, pm, pm+1~p2
			if( nums[pm]==nums[p1] || nums[pm]==nums[p2] ) {
				while(p1<pm) { 
					if(nums[p1]!=nums[pm]){ break; }
					p1++;
				}
				while(p2>pm) {
					if(nums[p2]!=nums[pm]){ break; }
					p2--;
				}
			} else {
				if( nums[pm]==target ) { return true; }
				if( nums[p1]<nums[pm] ) {
					if( nums[p1]<=target && target<=nums[pm] ) {
						p2 = pm-1;
					} else {
						p1 = pm+1;
					}
				} else {
					if( nums[pm]<target && target<=nums[p2] ) {
						p1 = pm+1;
					} else {
						p2 = pm-1;
					}
				}
			}
		}
		
		if(nums[p1]==target||nums[p2]==target) {
			return true;
		} else {
			return false;
		}
		
    }
}