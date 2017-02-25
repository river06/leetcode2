public class Solution {
    public int removeElement(int[] nums, int val) {
		if( nums.length ==0 ){ return 0; }
		
		int p1=0;
		int p2=0;
		// find the first val
		while(p1<nums.length && p2<nums.length) {
			if(nums[p1] == val) {
				p2=p1+1;
				while(p2<nums.length) {
					if( nums[p2] != val ) {
						int tmp = nums[p2];
						nums[p2] = nums[p1];
						nums[p1] = tmp;
						p1++;
						break;
					}
					p2++;
				}
			} else {
				p1++;
			}
		}
		return p1;
    }
}