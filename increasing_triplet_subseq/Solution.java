import java.util.*;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<3) return false;
        
        // Initial smallest and second smallest values to Integer.MAX_VAL works
        int min_val = Integer.MAX_VALUE;
        int mid_val = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++) {
            int cur_val = nums[i];
            if(cur_val<min_val) {
                min_val = cur_val;
            } else if (cur_val>min_val && cur_val < mid_val) {
                mid_val = cur_val;
            } else if (cur_val > mid_val) {
                return true;
            }
        }
        return false;
    }
}

// IMO, this is a very hard question and can hardly be extended to other questions.
// I might not be able to solve it if I see it again.
// The key point of the solution is that it is OK to update the pointer to the smallest value. Even if the smallest value pointer is behind the second value pointer, it is OK. This case means that there is another small value before the second smallest value but is greater than the current smallest value. If there is another value larger than the second smallest value, then, it is always larger than the value which is smaller than the second smallest value but larger than the current smallest value.