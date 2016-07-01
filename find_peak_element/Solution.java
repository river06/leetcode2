public class Solution {
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private int helper( int[] nums, int idxl, int idxr) {
        // base case
        if(idxr -idxl <=1) return nums[idxl]>=nums[idxr] ? idxl : idxr;
        
        int idxm = (idxl + idxr)/2;
        if( nums[idxm] > nums[idxm-1] && nums[idxm] > nums[idxm+1]) {
            return idxm;
        }else if( nums[idxm]< nums[idxm-1]) {
            return helper(nums, idxl, idxm-1);
        }else{
            return helper(nums, idxm+1, idxr);
        }
    }
}