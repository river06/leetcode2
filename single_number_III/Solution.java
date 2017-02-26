public class Solution {
    public int[] singleNumber(int[] nums) {
        if( nums.length==0 ) { return null; }

		int xorResult = 0;
		for( int num: nums ) {
			xorResult ^= num;
		}

		// find the bit that the two numbers are different
		int iDiff = 0;
		for(; iDiff<32; iDiff++) {
			if( ((xorResult>>iDiff) & 1) > 0 ) { break; }
		}

		// divide the numbers into two groups and xor
		int num1 = 0;
		int num2 = 0;
		for( int num: nums ) {
			if( ((num>>iDiff) & 1) > 0 ) {
				num1 ^= num;
			} else {
				num2 ^= num;
			}
		}

		int[] ret = new int[2];
		ret[0] = num1;
		ret[1] = num2;
		return ret;
    }
}
