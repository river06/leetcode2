import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] ret = new int[2];
		if(nums==null) return null;

		Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			int num = nums[i];
			if(hashTable.containsKey( target - num) ) {
				ret[0] = hashTable.get(target-num);
				ret[1] = i;
				return ret;
			}
			if( !hashTable.containsKey(num)) {
				hashTable.put(num, i);
			} 
		}
		return null;
    }
}
