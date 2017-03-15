import java.util.*;
public class Solution {
    public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0) { return 0;}
		
        Set<Integer> numSet = new HashSet<Integer>();
		for(int num: nums) {
			numSet.add( num );
		}

		int ret = 0;
		for(int num: nums) {
			if( !numSet.contains( num ) ) { continue; }

			int left = num-1;
			while( numSet.contains(left) ) {
				numSet.remove( left );
				left--;
			}

			int right = num+1;
			while( numSet.contains(right) ) {
				numSet.remove(right);
				right++;
			}

			numSet.remove(num);

			ret = Math.max( ret, right-left-1);
		}

		return ret;
    }
}
