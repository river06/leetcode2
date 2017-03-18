public class Solution {
    public int maxProduct(int[] nums) {
        int negative = 0;
		int positive = 0;
		int ret = Integer.MIN_VALUE;
		
		for(int num: nums) {
			if( positive == 0 && negative == 0 ) {
				if( num < 0 ) {
					negative = num;
					ret = Math.max(ret, negative);
				} else {
					positive = num;
					ret = Math.max(ret, positive);
				}
			} else {
				if( num < 0 ) {
					int pre_positive = positive;
					positive = negative * num;
					negative = Math.min(pre_positive * num, num);
				} else {
					positive = Math.max( positive*num, num);
					negative = Math.min( negative*num, num);
				}
				ret = Math.max( ret, positive );
			}
		}
		return ret;
    }
}
