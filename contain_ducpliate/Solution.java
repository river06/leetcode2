import java.util.*;
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if( nums.length == 0 ) { return false; }
        HashSet hashSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(hashSet.contains(nums[i])) { 
        		return true; 
        	} else {
        		hashSet.add(nums[i]);
        	}
        }
        return false;
    }
}