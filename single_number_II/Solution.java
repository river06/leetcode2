public class Solution {
	public int singleNumber(int[] nums) {

		if( nums.length==0 ) { return 0; }

		int t1 = 0; // hold bits occuring one time
		int t2 = 0; // hold bits occuring twice
		int t3 = 0; // hold bits occuring three times

		for( int num: nums ) {

			t3 = (t2&num) | (t3 & (~num));
			t2 = (t1&num) | (t2 & (~num));
			t1 = (t1^num) & (~t3);
			
		}
		return t1;
	}

	
	/**
	 * Does not take extra space, but takes O(32n) time
	 * handles negative number
	 */
	public int singleNumberBad(int[] nums) {
		int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += ((nums[j] >> i) & 1); 
            }
            result |= ((count % 3) << i);
        }
        
        return result;
	}
						
	/**
	 * This method requires O(n) space
	 */
    public int singleNumberWorst(int[] nums) {
        if( nums.length==0 ){ return 0; }

		int[] bits = new int[32];

		for( int num:nums ) {
			for( int i=0; i<32; i++) {
				// if( num&(1<<i) >0 ) { bits[i]++; } 
                /* this does not work since when shifting 31 times,
				  it is negative! not positive!
				  So always use right shift! */
				
				bits[i] += (num>>i)&1 ;
			}
		}

		int ret = 0;
		for( int i=0; i<32; i++) {
			ret |= (bits[i]%3)<<i;
		}

		return ret;
    }
}
