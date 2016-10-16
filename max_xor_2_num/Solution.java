import java.util.*;
public class Solution {
    public int findMaximumXOR(int[] nums) {
        // this solution uses bit operation
		// use a set of quicky find the pairs
		// use max to keep track of the largest possible value
		int max = 0;
		int mask=0;
		for(int i=31; i>=0; i--) {
			// build the sets
			HashSet<Integer> set = new HashSet<Integer>();
			mask |= (1<<i);
			for(int num : nums) {
				set.add( num & mask ); // keep the left digits
			}

			int tmp = max | (1<<i);
			for(int num : set) {
				if( set.contains( tmp^num ) ) {
					max = tmp;
					break;
				}
			}
		}
		return max;
    }
}
