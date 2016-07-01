public class Solution {
    public int findDuplicate(int[] nums) {
        // this solution uses the beautiful algorithm that finds the loop in a chain
        // complexity: O(n)
        // space complexity: O(1)
        int idx_slow = 0;
        int idx_fast = 0;
        do {
            idx_slow = nums[idx_slow];
            idx_fast = nums[nums[idx_fast]];
        } while(idx_fast != idx_slow);
        int idx_ret = 0;
        while( idx_ret != idx_slow) {
            idx_slow = nums[idx_slow];
            idx_ret = nums[idx_ret];
        }
        return idx_ret;
    }
}