public class Solution {
    public void nextPermutation(int[] nums) {
        if( nums.length<=1 ){ return; }
		
		int lPos = nums.length-2;
		
		while( lPos>-1 ) {
			if( nums[lPos]<nums[lPos+1] ) {
				break;
			}
			lPos--;
		}
		
		if( lPos>=0 ) {
			int lVal = nums[lPos];
			int rPos = nums.length-1;
			// find the first number that is larger than lVal
			while( rPos>lPos ) {
				if( nums[rPos]>lVal ) { break; }
				rPos--;
			}
			
			int tmp = nums[rPos];
			nums[rPos] = nums[lPos];
			nums[lPos] = tmp;
		}
		
		// sort numbers to the right of lPos, must be in decreasing order already
		for( int i=lPos+1; i<=lPos+(nums.length-lPos-1)/2; i++ ) {
			int tmp = nums[i];
			nums[i] = nums[nums.length+lPos-i];
			nums[nums.length-1+lPos+1-i] = tmp;
		}
		
    }
}