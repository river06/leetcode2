public class Solution {
    public void sortColors(int[] nums) {
        // bucket sort idea

		int p1 = -1; // start of ones
		int p2 = -1; // start of twos
		
		for( int i=0; i<nums.length; i++ ) {
			if( nums[i]==0 ) {
				int p0 = i;
				if( p2 >=0 ) {
					swap(nums, p2, p0);
					p0 = p2;
					p2++;
				}
				if( p1 >=0 ) {
					swap(nums, p1, p0);
					p1++;
				}
			} else if ( nums[i]==1 ) {
				if( p2 >= 0 ) {
					swap(nums, i, p2);
					p2++;
					if( p1==-1 ) { p1 = p2-1; }
				} else {
					if( p1==-1 ) { p1 = i; }
				}
				
			} else {
				if( p2==-1 ) { p2 = i; }
			}
		}
    }
	private void swap(int[] nums, int p1, int p2) {
		int tmp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = tmp;
	}
}
