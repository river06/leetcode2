import java.util.*;

/**
 * Variation of Moore's Algorithm
 * There can be at most 2 elements that appear more than
 * floor(n/3) times
 * Notice the algorithm, the reduced times must be added to the other
 * candicate first. So, if one element appear x>n/3 times,
 * it cannot be deducted for (n-x)/2 < (n-n/3)/2 = n/3 times.
 * Therefore, if any element appears more than n/3 times, it must be
 * kept until the end of the algorithm
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer n1 = null;
		Integer n2 = null;
		int c1 = 0;
		int c2 = 0;

		for (int num: nums) {
			if (n1!=null && n1==num) {
				c1++;
			} else if (n2!=null && n2==num) {
				c2++;
			} else if (c1==0) {
				c1 = 1;
				n1 = num;
			} else if (c2==0) {
				c2 = 1;
				n2 = num;
			} else {
				c1--;
				c2--;
			}
		}

		c1 = 0;
		c2 = 0;
		for (int num: nums) {
			if (n1!=null && num == n1) {
				c1++;
			} else if (n2!=null && num==n2) {
				c2++;
			}
		}

		List<Integer> ret = new LinkedList<Integer>();
		
		if (c1 > nums.length/3) { ret.add(n1); }
		if (c2 > nums.length/3) { ret.add(n2); }
			
		return ret;			   
    }
}
