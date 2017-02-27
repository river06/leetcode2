import java.util.*;
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if( nums.length == 0 ) { return false; }
        Hashtable<Integer, ArrayList<Integer>> hashTable 
            = new Hashtable<Integer, ArrayList<Integer>>();
        for(int i=0; i<nums.length; i++) {
            if(hashTable.containsKey(nums[i])) { 
                ArrayList<Integer> indices = hashTable.get(nums[i]);
                for( Integer index: indices ) {
                    if( Math.abs(index - i)<=k ) {
                        return true;
                    }
                }
                indices.add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                hashTable.put(nums[i], indices);
            }
        }
        return false;
    }
}