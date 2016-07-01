public class Solution {
    public int findMin(int[] nums) {
        // this function assumes that the num is sorted by increasing order
        return findMinHelper(nums,0, nums.length-1);
        
    }
    private int findMinHelper(int[] nums, int idx1, int idx2) {
        
        // deal with duplicates first
        int idxMid = (idx1 + idx2)/2;
        if( nums[idxMid] == nums[idx1] && nums[idxMid] == nums[idx2]){
            while(idx1<idxMid) {
                idx1++;
                if( nums[idx1] != nums[idxMid]) break;
            }
            while(idx2> idxMid) {
                idx2--;
                if( nums[idx2] != nums[idxMid]) break;
            }
        }
        
        if(idx1==idx2) return nums[idx1];
        if(nums[idx1] < nums[idx2]) return nums[idx1];
        idxMid = (idx1+idx2)/2;
        if( nums[idxMid] >= nums[idx1]) {
            return findMinHelper(nums, idxMid+1, idx2);
        } else {
            return findMinHelper(nums, idx1, idxMid);
        }
    }
}